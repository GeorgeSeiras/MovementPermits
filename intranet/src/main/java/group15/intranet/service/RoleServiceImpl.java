package group15.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.model_request.RolesDetailsModelRequest;
import group15.intranet.repository.RoleRepository;
import group15.intranet.repository.UserRepository;

@Transactional
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
}
