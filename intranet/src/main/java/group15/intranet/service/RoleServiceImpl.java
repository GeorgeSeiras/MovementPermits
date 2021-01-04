package group15.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Role;
import group15.intranet.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;


	@Override
	public ResponseEntity<Role> addRole(Role role) {
		Role checkedRole = roleRepository.findByAuthority(role.getAuthority());
		if(checkedRole == null) {
			return new ResponseEntity<Role>(checkedRole,HttpStatus.BAD_REQUEST);
		}
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
