package group15.intranet.rest_controller;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import group15.intranet.entity.Permit;
import group15.intranet.model_request.CreatePermitRequestModel;
import group15.intranet.model_request.PermitStatistics;
import group15.intranet.model_request.UpdatePermitDetailsRequestModel;
import group15.intranet.service.PermitServiceImpl;

@RestController
@RequestMapping("/permits")
public class PermitsRestController {

	@Autowired
	PermitServiceImpl permitService;

	@GetMapping
	@ResponseBody
	public List<Permit> getPermits(@RequestParam(required = false) Map<String, String> searchParams)
			throws ParseException {
		return this.permitService.getPermits(searchParams);
	}

	@GetMapping("/statistics")
	public PermitStatistics getStatistcs() {
		return permitService.getStatistics();
	}

	@GetMapping("/{permitID}")
	public ResponseEntity<Permit> getPermitById(@PathVariable int permitID,@RequestParam(required = false) int userID) {
		return this.permitService.getPermitById(permitID,userID);
	}

	@GetMapping("/supervisor/{id}")
	public ResponseEntity<List<Permit>> getSupervisorPermits(@PathVariable int id) {
		return this.permitService.getSupervisorPermits(id);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<Permit>> getUserPermits(@PathVariable int userId) {
		return this.permitService.getUserPermits(userId);
	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<Permit> addPermit(@Valid @RequestBody CreatePermitRequestModel permitCreateModel) {
		return permitService.addPermit(permitCreateModel);
	}

	@PutMapping("/{id}/status")
	@ResponseBody
	public ResponseEntity<Permit> updatePermits(@PathVariable int id,
			@Valid @RequestBody UpdatePermitDetailsRequestModel permitDetails) {
		return permitService.updatePermit(id, permitDetails);
	}

}
