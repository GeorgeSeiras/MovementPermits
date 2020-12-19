package intranet.hua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupervisorController {
	
	@RequestMapping("/supervisor")
	public String hello() {
		return "supervisor";
	}

}
