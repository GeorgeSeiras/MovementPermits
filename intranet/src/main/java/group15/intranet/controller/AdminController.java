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
	
	@GetMapping("user")
	public String adminAddUser() {
		return "admin-users";
	}

	@GetMapping("user/create")
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
	
	@GetMapping("role")
	public String adminCreateRole() {
		return "admin-roles";
	}
	
	@GetMapping("role/create")
	public String adminDeleteRole() {
		return "admin-roles-create";
	}
	
}
