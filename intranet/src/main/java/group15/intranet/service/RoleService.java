package group15.intranet.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Role;

public interface RoleService {

	ResponseEntity<Role> addRole(Role role);

	ResponseEntity<Role> deleteRole(String roleName);

	List<Role> getRoles();
}
