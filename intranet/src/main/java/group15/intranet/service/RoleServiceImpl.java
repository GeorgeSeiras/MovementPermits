package group15.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.model_request.RolesDetailsModelRequest;
import group15.intranet.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;


	@Override
	public ResponseEntity<Role> addRole(RolesDetailsModelRequest roleName) {
		Role checkedRole = roleRepository.findByAuthority(roleName.getRoleName());
		if(checkedRole != null) {
			return new ResponseEntity<Role>(checkedRole,HttpStatus.BAD_REQUEST);
		}
		Role role = new Role();
		role.setAuthority(roleName.getRoleName());
		role.setUsers(new ArrayList<User>());
		roleRepository.save(role);
		return new ResponseEntity<Role>(role, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Role> deleteRole(String roleName) {
		Role checkedRole = roleRepository.findByAuthority(roleName);
		if(checkedRole==null) {
			return new ResponseEntity<Role>(checkedRole,HttpStatus.NOT_FOUND);
		}
		roleRepository.delete(checkedRole);
		return new ResponseEntity<Role>(checkedRole,HttpStatus.OK);
	}

	@Override
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
}
