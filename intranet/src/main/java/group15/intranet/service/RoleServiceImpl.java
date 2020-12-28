package group15.intranet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Role;
import group15.intranet.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;


	@Override
	public void addRole(Role r) {
		roleRepository.save(r);
	}

	@Override
	public void deleteRole(Role r) {
		roleRepository.delete(r);
	}
}
