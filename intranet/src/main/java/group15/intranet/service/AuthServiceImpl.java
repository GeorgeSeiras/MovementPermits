package group15.intranet.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.model_request.LogInRequestModel;
import group15.intranet.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	private Environment env;

	@Autowired
	UserRepository userRepository;

	@Autowired
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public ResponseEntity<HashMap<String, String>> logInUser(LogInRequestModel loginCredentials) {
		User user = userRepository.findOneByUsername(loginCredentials.getUsername());
		if (user == null) {
			return new ResponseEntity<HashMap<String, String>>(new HashMap<>(), HttpStatus.UNAUTHORIZED);
		}
		if (!passwordEncoder().matches(loginCredentials.getPassword(), user.getPassword())) {
			return new ResponseEntity<HashMap<String, String>>(new HashMap<>(), HttpStatus.UNAUTHORIZED);
		}
		Role userRole = new Role();
		userRole.setAuthority("ROLE_USER");
		if (user.getAuthorities().indexOf(userRole) == -1) {
			return new ResponseEntity<HashMap<String, String>>(new HashMap<>(), HttpStatus.FORBIDDEN);

		}
		String jws = Jwts.builder().signWith(SignatureAlgorithm.HS256, env.getProperty("secret"))
				.setSubject(user.getUsername()).compact();
		HashMap<String, String> res = new HashMap<>();
		res.put("jwt", jws);
		return new ResponseEntity<HashMap<String, String>>(res, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<User> authUser(String token) {
		String username = Jwts.parser().setSigningKey(env.getProperty("secret")).parseClaimsJws(token).getBody()
				.getSubject();
		User user = userRepository.findOneByUsername(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
