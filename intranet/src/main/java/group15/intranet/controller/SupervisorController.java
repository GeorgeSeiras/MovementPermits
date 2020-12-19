package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SupervisorController {
	
	@GetMapping(value={"/","/home","/supervisor"})
	public String hello() {
		return "supervisor";
	}

}
