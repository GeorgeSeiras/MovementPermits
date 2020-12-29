package group15.intranet.rest_controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.User;
import group15.intranet.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersRestController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<User> addUser(@Valid @RequestBody User user){
		return userService.addUser(user);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
		return userService.updateUser(user);
	}
}
