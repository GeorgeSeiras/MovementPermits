package group15.intranet.service;

import java.util.List;
import java.util.Map;

import group15.intranet.entity.Department;
import group15.intranet.entity.User;

public interface DepartmentService {
	User getDeptsSupervisor(int dept_id);
	Department getDepartmentById(int id);
	Department getDepartmentBySuperId(int id);
}
