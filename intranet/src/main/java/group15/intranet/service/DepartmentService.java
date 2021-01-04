package group15.intranet.service;


import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Department;
import group15.intranet.entity.User;

public interface DepartmentService {
	User getDeptsSupervisor(int dept_id);
	ResponseEntity<Department> getDepartmentById(int id);
	ResponseEntity<Department> addDepartment(Department dep);
	ResponseEntity<Integer> deleteDepartment(int id);
	ResponseEntity<Department> updateDepartment(Department dep);
	Department getDepartmentBySuperId(int id);
}
