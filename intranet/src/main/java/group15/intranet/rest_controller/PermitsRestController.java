package group15.intranet.rest_controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import group15.intranet.entity.Permit;
import group15.intranet.entity.Role;
import group15.intranet.entity.User;
import group15.intranet.repository.PermitRepository;
import group15.intranet.service.DepartmentServiceImpl;
import group15.intranet.service.PermitServiceImpl;
import group15.intranet.service.RoleServiceImpl;
import group15.intranet.service.UserServiceImpl;

@RestController
public class PermitsRestController {

	@Autowired
	PermitServiceImpl permitService;
	

	@Autowired
	PermitRepository repo;

	@Autowired
	RoleServiceImpl roleService;

	@Autowired
	UserServiceImpl userService;

	@Autowired
	DepartmentServiceImpl departmentService;

	@GetMapping("/permits/{id}")
	public Permit getPermitById(@PathVariable int id) {
		return this.permitService.getPermitById(id);
	}

	@GetMapping("/permits")
	@ResponseBody
	public List<Permit> getPermits(@RequestParam(required = false) Map<String, String> searchParams) {
		System.out.println(searchParams);
		return this.permitService.getPermits(searchParams);
	}


}
