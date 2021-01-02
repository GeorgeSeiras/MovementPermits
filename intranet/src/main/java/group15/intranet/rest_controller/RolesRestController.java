package group15.intranet.rest_controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.Role;
import group15.intranet.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RolesRestController {
	
	@Autowired
	RoleService roleService;

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Role> addRole(@Valid @RequestParam Role role){
		return roleService.addRole(role);
	}
	
	@DeleteMapping("/{roleName}")
	@ResponseBody
	public ResponseEntity<Role> deleteRole(@PathVariable String roleName){
		return roleService.deleteRole(roleName);
	}
}
