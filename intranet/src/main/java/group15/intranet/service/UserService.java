package group15.intranet.service;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;

public interface UserService {

	User findUserById(int id);
	void addUser(User u);
	void deleteUser(User u);
	void assignRoleToUser(Role r, User u);
	
}
