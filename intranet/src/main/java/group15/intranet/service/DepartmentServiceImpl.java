package group15.intranet.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import group15.intranet.criteria.SearchCriteria;
import group15.intranet.criteria.SearchOperation;
import group15.intranet.entity.Department;
import group15.intranet.entity.Permit;
import group15.intranet.entity.User;
import group15.intranet.repository.DepartmentRepository;
import group15.intranet.repository.PermitRepository;
import group15.intranet.repository.UserRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Department getDepartmentById(int id) {
		return departmentRepository.findById(id);
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
}
