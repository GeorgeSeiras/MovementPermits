package group15.intranet.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;

public interface UserService {

	List<User> getAllUsers();
	ResponseEntity<User> findUserById(int id);
	ResponseEntity<User> addUser(User u);
	ResponseEntity<User> deleteUser(int id);
	ResponseEntity<User> updateUser(User u);
	ResponseEntity<User> assignRoleToUser(Role r, User u);
	
}
