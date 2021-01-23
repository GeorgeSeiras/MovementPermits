package group15.intranet.service;

import java.util.List;


import org.springframework.http.ResponseEntity;


import group15.intranet.entity.User;
import group15.intranet.model_request.AuthorityRequestModel;
import group15.intranet.model_request.UserCreateRequestModel;
import group15.intranet.model_request.UserDetailsRequestModel;

public interface UserService {

	List<User> getAllUsers();
	ResponseEntity<User> findUserById(int id);
	ResponseEntity<User> deleteUser(int id);
	ResponseEntity<User> updateUser(int id, UserDetailsRequestModel user);
	ResponseEntity<User> assignRoleToUser(int id, AuthorityRequestModel authority);
	ResponseEntity<User> removeRoleFromUser(int id, String auth);
	ResponseEntity<User> addUser(UserCreateRequestModel user);
	ResponseEntity<User> getMe(String username);
	
}
