package group15.intranet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;
import group15.intranet.model_request.UpdateUserDetailsRequestModel;
import group15.intranet.model_request.UserDetailsRequestModel;
import group15.intranet.repository.DepartmentRepository;
import group15.intranet.repository.RoleRepository;
import group15.intranet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	DepartmentRepository depRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public ResponseEntity<User> addUser(UserDetailsRequestModel user) {
		User checkedUser = userRepository.findByUserID(user.getUserID());
		
		if(checkedUser!=null) {
			return new ResponseEntity<User>(checkedUser,HttpStatus.ALREADY_REPORTED);
		}
		checkedUser = new User();
		checkedUser.setFname(user.getFname());
		checkedUser.setLname(user.getLname());
		checkedUser.setAddress(user.getAddress());
		checkedUser.setPhoneNum(user.getPhoneNum());
		checkedUser.setDept(depRepository.findById(user.getDeptId()));
		checkedUser.setUsername(user.getUsername());
		checkedUser.setPassword(user.getPassword());
		for(int i=0;i<user.getAuthorities().size();i++) {
			checkedUser.addAuthority(roleRepository.findByAuthority(user.getAuthorities().get(i)));
		}
		checkedUser.setEnabled(user.getEnabled());
		userRepository.save(checkedUser);
		return new ResponseEntity<User>(checkedUser,HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<User> updateUser(int id, UserDetailsRequestModel user) {
		User checkedUser = userRepository.findByUserID(id);
		if(checkedUser==null) {
			return new ResponseEntity<User>(checkedUser,HttpStatus.NOT_FOUND);
		}
		System.out.println(depRepository.findById(user.getDeptId()));
		checkedUser.setFname(user.getFname());
		checkedUser.setLname(user.getLname());
		checkedUser.setAddress(user.getAddress());;
		checkedUser.setPhoneNum(user.getPhoneNum());
		checkedUser.setDept(depRepository.findById(user.getDeptId()));
		checkedUser.setUsername(user.getUsername());
		checkedUser.setPassword(user.getPassword());
		checkedUser.setAuthorities(new ArrayList<Role>());
		for(int i=0;i<user.getAuthorities().size();i++) {
			checkedUser.addAuthority(roleRepository.findByAuthority(user.getAuthorities().get(i)));
		}
		checkedUser.setEnabled(user.getEnabled());
		userRepository.save(checkedUser);
		return new ResponseEntity<User>(checkedUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> deleteUser(int id) {
		User checkedUser = userRepository.findByUserID(id);
		if (checkedUser == null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.NOT_FOUND);
		}
		if(checkedUser.getUserID()==checkedUser.getDept().getSupervisor()) {
			return new ResponseEntity<User>(checkedUser,HttpStatus.NOT_MODIFIED);
		}
		checkedUser.setDept(null);
		checkedUser.setAuthorities(null);
		userRepository.delete(checkedUser);
		return new ResponseEntity<User>(checkedUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> findUserById(int id) {
		User checkedUser = userRepository.findByUserID(id);
		if (checkedUser == null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(checkedUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> assignRoleToUser(Role role, User user) {
		User temp = userRepository.findByUserID(user.getUserID());
		if (temp == null) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		List<Role> roles = new ArrayList();

		roles = userRepository.findByUserID(user.getUserID()).getAuthorities();
		roles.add(role);
		temp.setAuthorities(roles);
		userRepository.save(temp);
		return null;
	}

}
