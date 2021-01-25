package group15.intranet.service;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.User;
import group15.intranet.model_request.LogInRequestModel;

public interface AuthService {

	ResponseEntity<HashMap<String, String>> logInUser(LogInRequestModel loginCredentials);
	ResponseEntity<User> authUser(String token);
	
}
