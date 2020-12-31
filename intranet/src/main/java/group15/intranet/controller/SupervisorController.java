package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {
	
	@GetMapping
	public String supervisor() {
		return "supervisor";
	}

	
	@GetMapping("permits/view/{id}")
	public String supervisorPermits() {
		return "supervisor-permit";
	}
}
