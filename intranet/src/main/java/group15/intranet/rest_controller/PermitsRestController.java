package group15.intranet.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermitsRestController {

	@Autowired
	Object permitsRepository;
	
	@GetMapping("/permits")
	public List<Object> getAllPermits(){
		return null;
	}
}
