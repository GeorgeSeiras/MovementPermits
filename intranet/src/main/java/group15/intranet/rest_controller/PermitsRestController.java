package group15.intranet.rest_controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.Permit;
import group15.intranet.repository.PermitRepository;

@RestController
public class PermitsRestController {

	@Autowired
	PermitRepository permitRepository;
	
	@GetMapping("/permits/{id}")
	public Permit getPermitById(@PathVariable int id){
		Optional<Permit> permit = permitRepository.findById(id);
		return permit.get();
	}
	
	@GetMapping("/permits")
	@ResponseBody
	public Permit getPermits(@RequestParam("first")int id, @RequestParam("second") boolean status) {
		Optional<Permit> permit = permitRepository.findById(id);
		return permit.get();
	}
	
}
