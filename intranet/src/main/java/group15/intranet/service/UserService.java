package group15.intranet.service;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;

public interface UserService {

	ResponseEntity<User> findUserById(int id);
	ResponseEntity<User> addUser(User u);
	ResponseEntity<User> deleteUser(User u);
	ResponseEntity<User> updateUser(User u);
	ResponseEntity<User> assignRoleToUser(Role r, User u);
	
}
