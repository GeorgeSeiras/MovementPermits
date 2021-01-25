package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@GetMapping
	public String admin() {
		return "admin";
	}
	
	@GetMapping("users")
	public String adminAddUser() {
		return "admin-users";
	}

	@GetMapping("users/create")
	public String adminDeleteUser() {
		return "admin-user-create";
	}

	@GetMapping("department")
	public String adminCreateDepartment() {
		return "admin-departments";
	}
	
	@GetMapping("department/create")
	public String adminDeleteDepartment() {
		return "admin-department-create";
	}
	
	@GetMapping("roles/{id}")
	public String adminUserRoles() {
		return "admin-role-assign";
	}
}
