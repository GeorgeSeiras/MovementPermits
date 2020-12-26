package group15.intranet.rest_controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.Permit;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;
import group15.intranet.repository.PermitRepository;
import group15.intranet.service.PermitServiceImpl;

@RestController
public class PermitsRestController {

	@Autowired
	PermitRepository permitRepository;

	@Autowired
	PermitServiceImpl permitService;

	@GetMapping("/permits/{id}")
	public Permit getPermitById(@PathVariable int id) {
		return this.permitService.getPermitById(id);
	}

	@GetMapping("/permits")
	@ResponseBody
	public List<Permit> getPermits(@RequestParam(required = false) Map<String, String> searchParams) {
		return this.permitService.getPermits(searchParams);
	}
	
	@PutMapping(path="/permits/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Permit> updatePermits(@PathVariable int id, @Valid @RequestBody UpdatePermitDetailsRequestModel permitDetails) {
		System.out.println(permitDetails.getStatus());
		return permitService.updatePermit(id, permitDetails);
	}

}
