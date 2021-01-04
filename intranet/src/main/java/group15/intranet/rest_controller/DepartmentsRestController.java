package group15.intranet.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import group15.intranet.entity.Department;
import group15.intranet.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentsRestController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("")
	@ResponseBody
	public ResponseEntity<List<Department>> getDepById(){
		return departmentService.getDepartments();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Department> getDepById(@PathVariable int id){
		return departmentService.getDepartmentById(id);
	}
	
	@PostMapping()
	@ResponseBody
	public ResponseEntity<Department> addDep(@RequestBody Department dep){
		return departmentService.addDepartment(dep);
	}
	
	@PutMapping()
	@ResponseBody
	public ResponseEntity<Department> updateDep(@RequestBody Department dep){
		return departmentService.updateDepartment(dep);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Integer> deleteDep(@PathVariable int id){
		return departmentService.deleteDepartment(id);
	}
	
	
}
