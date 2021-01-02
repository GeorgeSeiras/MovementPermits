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
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		return userService.deleteUser(id);
	}
}
