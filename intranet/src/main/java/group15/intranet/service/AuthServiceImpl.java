package group15.intranet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group15.intranet.entity.User;
import group15.intranet.model_request.LogInRequestModel;
import group15.intranet.repository.UserRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;


@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public ResponseEntity<String> logInUser(LogInRequestModel loginCredentials) {
		User user = userRepository.findOneByUsername(loginCredentials.getUsername());
		if(passwordEncoder().encode(loginCredentials.getPassword()) == user.getPassword()) {
			String jws = Jwts.builder().setSubject(user.getUsername()).compact();
			return new ResponseEntity<String>(jws, HttpStatus.OK);
		}
		return null;
	}

	@Override
	public ResponseEntity<User> authUser(String token) {
		String username = Jwts.parser().parseClaimsJws(token).getBody().getSubject();
		User user = userRepository.findOneByUsername(username);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
