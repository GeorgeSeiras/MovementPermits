package group15.intranet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.model_request.AuthorityRequestModel;
import group15.intranet.model_request.UserCreateRequestModel;
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
	public ResponseEntity<User> updateUser(int id, UserDetailsRequestModel user) {

		User checkedUser = userRepository.findByUserID(id);
		if (checkedUser == null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.NOT_FOUND);
		}
		checkedUser.setFname(user.getFname());
		checkedUser.setLname(user.getLname());
		checkedUser.setAddress(user.getAddress());
		;
		checkedUser.setPhoneNum(user.getPhoneNum());
		checkedUser.setDept(depRepository.findByDeptName(user.getDepartment()));

		userRepository.save(checkedUser);
		return new ResponseEntity<User>(checkedUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> deleteUser(int id) {
		User checkedUser = userRepository.findByUserID(id);
		if (checkedUser == null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.NOT_FOUND);
		}
		if (checkedUser.getUserID() == checkedUser.getDept().getSupervisor()) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.BAD_REQUEST);
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
	public ResponseEntity<User> assignRoleToUser(int id, AuthorityRequestModel authority) {

		User checkedUser = userRepository.findByUserID(id);
		if (checkedUser == null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.NOT_FOUND);
		}

		Role authFound = roleRepository.findByAuthority(authority.getAuthority());

		if (authFound == null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.NOT_FOUND);
		}
		for (int i = 0; i < checkedUser.getAuthorities().size(); i++) {
			if (checkedUser.getAuthorities().get(i).getAuthority() == authFound.getAuthority()) {
				return new ResponseEntity<User>(checkedUser, HttpStatus.BAD_REQUEST);
			}
		}
		checkedUser.getAuthorities().add(authFound);
		userRepository.save(checkedUser);
		return new ResponseEntity<User>(checkedUser, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<User> removeRoleFromUser(int id, String auth) {
		User user = userRepository.findByUserID(id);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
		}
		for (int i = 0; i < user.getAuthorities().size(); i++) {
			if (user.getAuthorities().get(i).getAuthority().equals(auth)) {
				user.getAuthorities().remove(i);
				userRepository.save(user);
				return new ResponseEntity<User>(user, HttpStatus.OK);
			}
		}
		return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<User> addUser(UserCreateRequestModel user) {
		User checkedUser = userRepository.findByUserID(user.getUserID());
		if (checkedUser != null) {
			return new ResponseEntity<User>(checkedUser, HttpStatus.ALREADY_REPORTED);
		}
		checkedUser = new User();
		checkedUser.setFname(user.getFname());
		checkedUser.setLname(user.getLname());
		checkedUser.setAddress(user.getAddress());
		checkedUser.setPhoneNum(user.getPhoneNum());
		checkedUser.setDept(depRepository.findByDeptName(user.getDepartment()));
		checkedUser.setUsername(user.getUsername());
		checkedUser.setPassword(user.getPassword());
		checkedUser.setEnabled(true);
		for (int i = 0; i < user.getAuthorities().size(); i++) {
			checkedUser.addAuthority(roleRepository.findByAuthority(user.getAuthorities().get(0)));
		}
		userRepository.save(checkedUser);
		return new ResponseEntity<User>(checkedUser, HttpStatus.OK);
	}


}
