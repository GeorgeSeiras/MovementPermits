package group15.intranet.rest_controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.User;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;
import group15.intranet.model_request.UpdateUserDetailsRequestModel;
import group15.intranet.model_request.UserDetailsRequestModel;
import group15.intranet.service.UserService;

@RestController
@RequestMapping("/users")
public class UsersRestController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> findUserById(@PathVariable int id){
		return userService.findUserById(id);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<User> addUser(@Valid @RequestBody UserDetailsRequestModel user){
		return userService.addUser(user);
	}
	
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> updateUser(@PathVariable int id, @Valid @RequestBody UpdateUserDetailsRequestModel user){
		return userService.updateUser(id,user);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		return userService.deleteUser(id);
	}
}
