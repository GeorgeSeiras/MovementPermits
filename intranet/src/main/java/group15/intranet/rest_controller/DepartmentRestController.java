package group15.intranet.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import group15.intranet.entity.Department;
import group15.intranet.entity.User;
import group15.intranet.repository.DepartmentRepository;
import group15.intranet.service.DepartmentService;

@RestController
public class DepartmentRestController {
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/department/{id}")
	public Department getDepartmentById(@PathVariable int id) {
		return this.departmentService.getDepartmentById(id);
	}

	@GetMapping("/department/supervisor/{id}")
	public User getDeptsSuper(@PathVariable int id) {
		return this.departmentService.getDeptsSupervisor(id);
	}
}
