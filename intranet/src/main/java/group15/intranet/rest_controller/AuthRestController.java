package group15.intranet.rest_controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.User;
import group15.intranet.model_request.LogInRequestModel;
import group15.intranet.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthRestController {
	
	@Autowired
	AuthService authService;
	
	
	@GetMapping("/me")
	@ResponseBody
	public ResponseEntity<User> authUser(@RequestParam String jwt){
		return this.authService.authUser(jwt);
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<HashMap<String,String>> login(@RequestBody LogInRequestModel loginCredentials) {
		return this.authService.logInUser(loginCredentials);
	}

}
