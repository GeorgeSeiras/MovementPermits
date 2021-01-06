package group15.intranet.rest_controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.Department;
import group15.intranet.entity.Role;
import group15.intranet.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RolesRestController {
	
	@Autowired
	RoleService roleService;

	@GetMapping("")
	@ResponseBody
	public List<Role> getRoles(){
		return roleService.getRoles();
	}
	
	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Role> addRole(@Valid @RequestBody Role role){
		return roleService.addRole(role);
	}
	
	@DeleteMapping("/{roleName}")
	@ResponseBody
	public ResponseEntity<Role> deleteRole(@PathVariable String roleName){
		return roleService.deleteRole(roleName);
	}
}
