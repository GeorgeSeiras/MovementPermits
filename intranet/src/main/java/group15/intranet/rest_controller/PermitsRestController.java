package group15.intranet.rest_controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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


	@GetMapping("/permits/{permitID}")
	public Permit getPermitById(@PathVariable int permitID) {
		Optional<Permit> permit = permitRepository.findById(permitID);
		return permit.get();
	}

	@GetMapping("/permits")
	@ResponseBody
	public List<Permit> getPermits(@RequestParam (required=false) String id) {
		System.out.println(id);
		Permit example = Permit.builder()
				.permitID(Integer.parseInt(id))
				.build();
		List<Permit> list = permitRepository.findAll(Example.of(example));
		System.out.println(list);
		return permitRepository.findAll(Example.of(example));
	}

}
