package group15.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void addUser(User u) {
		userRepository.save(u);
	}

	@Override
	public void deleteUser(User u) {
		userRepository.delete(u);
	}
	
	@Override
	public User findUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void assignRoleToUser(Role r, User u) {
		User temp = new User();
		temp = userRepository.findById(u.getUserID());
		List<Role> roles = new ArrayList();
		roles = userRepository.findById(u.getUserID()).getRoles();
		roles.add(r);
		temp.setRoles(roles);
		userRepository.save(temp);
	}

}
