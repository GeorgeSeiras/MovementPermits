package group15.intranet.rest_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.User;
import group15.intranet.model_request.LogInRequestModel;
import group15.intranet.service.AuthService;

@RestController
public class AuthRestController {
	
	@Autowired
	AuthService authService;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<User> authUser(String token){
		return null;
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<String> login(LogInRequestModel loginCredentials) {
		return this.authService.logInUser(loginCredentials);
	}

}
