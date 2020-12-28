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
	
	@GetMapping("addUser")
	public String adminAddUser() {
		return "add-user";
	}

	@GetMapping("deleteUser")
	public String adminDeleteUser() {
		return "update-user";
	}

	@GetMapping("updateUser")
	public String adminUpdateUser() {
		return "add-user";
	}
	
	@GetMapping("createDepartment")
	public String adminCreateDepartment() {
		return "create-department";
	}
	
	@GetMapping("deleteDepartment")
	public String adminDeleteDepartment() {
		return "delete-department";
	}
	
	@GetMapping("createRole")
	public String adminCreateRole() {
		return "create-role";
	}
	
	@GetMapping("deleteRole")
	public String adminDeleteRole() {
		return "delete-role";
	}
	
	@GetMapping("assignRole")
	public String assignRole() {
		return "assign-role";
	}
	
	@GetMapping("changeSupervisor")
	public String adminChangeSupervisor() {
		return "create-role";
	}
	
	
	
	
	
	
	
}
