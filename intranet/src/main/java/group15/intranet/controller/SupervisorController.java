package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupervisorController {
	
	@GetMapping("/supervisor")
	public String supervisor() {
		return "supervisor";
	}

	
	@GetMapping("/supervisor/permits/{id}")
	public String supervisorPermits() {
		return "supervisor-permit";
	}
}
