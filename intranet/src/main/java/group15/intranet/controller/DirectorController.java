package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/director")
public class DirectorController {

	@GetMapping
	public String director() {
		return "director";
	}
	
	@GetMapping("permits")
	public String directorPermits() {
		return "director-permits";
	}
}
