package group15.intranet.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.model_request.UpdateUserDetailsRequestModel;
import group15.intranet.model_request.UserDetailsRequestModel;

public interface UserService {

	List<User> getAllUsers();
	ResponseEntity<User> findUserById(int id);
	ResponseEntity<User> addUser(UserDetailsRequestModel u);
	ResponseEntity<User> deleteUser(int id);
	ResponseEntity<User> updateUser(int id, UserDetailsRequestModel user);
	ResponseEntity<User> assignRoleToUser(Role r, User u);
	
}
