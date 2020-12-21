package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class DirectorController {

	@GetMapping("/director")
	public String director() {
		return "director";
	}
	
	@GetMapping("/director/permits")
	public String directorPermits() {
		return "director-permits";
	}
}
