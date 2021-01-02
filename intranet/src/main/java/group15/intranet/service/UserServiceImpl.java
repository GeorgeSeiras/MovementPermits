package group15.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Permit;
import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.repository.DepartmentRepository;
import group15.intranet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DepartmentRepository depRepository;
	
	
	
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<User> addUser(User user) {
		User checkedUser = userRepository.findByUserID(user.getUserID());
		if(checkedUser!=null) {
			return new ResponseEntity<User>(user,HttpStatus.ALREADY_REPORTED);
		}
		userRepository.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<User> updateUser(User user) {
		User checkedUser = userRepository.findByUserID(user.getUserID());
		if(checkedUser==null) {
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		checkedUser=user;
		//checkedUser.setDept(depRepository.findById(user.getDept().getDeptID()));
		userRepository.save(checkedUser);
		return new ResponseEntity<User>(checkedUser,HttpStatus.OK);
	}



	@Override
	public ResponseEntity<User> deleteUser(int id) {
		User checkedUser = userRepository.findByUserID(id);
		if(checkedUser==null) {
			return new ResponseEntity<User>(checkedUser,HttpStatus.NOT_FOUND);
		}
		userRepository.delete(checkedUser);
		return new ResponseEntity<User>(checkedUser,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<User> findUserById(int id) {
		User checkedUser = userRepository.findByUserID(id);
		if(checkedUser == null) {
			return new ResponseEntity<User>(checkedUser,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(checkedUser,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> assignRoleToUser(Role role, User user) {
		User temp = userRepository.findByUserID(user.getUserID());
		if(temp == null) {
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		List<Role> roles = new ArrayList();
		roles = userRepository.findByUserID(user.getUserID()).getRoles();
		roles.add(role);
		temp.setRoles(roles);
		userRepository.save(temp);
		return null;
	}

}
