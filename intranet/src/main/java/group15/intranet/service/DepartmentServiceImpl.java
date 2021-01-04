package group15.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Department;
import group15.intranet.entity.User;
import group15.intranet.repository.DepartmentRepository;
import group15.intranet.repository.UserRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<Department> getDepartmentById(int id) {
		Department dep = departmentRepository.findById(id);
		if (dep == null) {
			return new ResponseEntity<Department>(dep, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(dep, HttpStatus.OK);
	}

	@Override
	public User getDeptsSupervisor(int dept_id) {
		Department d = departmentRepository.findById(dept_id);
		return d.getSupervisor();
	}

	@Override
	public Department getDepartmentBySuperId(int id) {
		List<Department> d = departmentRepository.findAll();
		Department dept = new Department();
		for (int i = 0; i < d.size(); i++) {
			if (d.get(i).getSupervisor().getUserID() == id) {
				dept = d.get(i);
			}
		}
		return dept;
	}

	@Override
	public ResponseEntity<Department> addDepartment(Department dep) {
		Department checkedDep = departmentRepository.findById(dep.getDeptID());
		if (checkedDep != null) {
			return new ResponseEntity<Department>(dep, HttpStatus.ALREADY_REPORTED);
		}
		System.out.println(dep);
		departmentRepository.save(dep);
		return new ResponseEntity<Department>(dep, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Integer> deleteDepartment(int id) {
		Department checkedDep = departmentRepository.findById(id);
		if (checkedDep == null) {
			return new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
		}

		List<User> users = userRepository.findAll();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getDept().getDeptID() == checkedDep.getDeptID()) {
				return new ResponseEntity<Integer>(id, HttpStatus.BAD_REQUEST);
			}
		}

		departmentRepository.delete(checkedDep);
		return new ResponseEntity<Integer>(id, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Department> updateDepartment(Department dep) {
		Department checkedDep = departmentRepository.findById(dep.getDeptID());
		if (checkedDep == null) {
			return new ResponseEntity<Department>(dep, HttpStatus.NOT_FOUND);
		}

		User checkedUser = userRepository.findByUserID(dep.getSupervisor().getUserID());
		if (checkedUser == null) {
			return new ResponseEntity<Department>(dep, HttpStatus.NOT_FOUND);
		}

		if (checkedDep.getSupervisor().getUserID() != checkedUser.getUserID()) {
			checkedUser.setDept(dep);
			userRepository.save(checkedUser);
		}

		departmentRepository.save(dep);
		return new ResponseEntity<Department>(dep, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Department>> getDepartments() {
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(), HttpStatus.OK);
	}
}
