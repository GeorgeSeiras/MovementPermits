package group15.intranet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HumanResourceController {

	@GetMapping("/hr/permits")
	public String hrPermits() {
		return "hr-permits";
	}
}
