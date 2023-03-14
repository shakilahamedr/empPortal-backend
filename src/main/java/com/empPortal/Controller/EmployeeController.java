package com.empPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empPortal.model.Employee;
import com.empPortal.Service.EmployeeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hi")
	public String getTest() {
		return "Hi Shakil";
	}
	
	@GetMapping("/secureHi")
	public String getAuthTest(@RequestHeader("Authorization") String authorization) {
		return "Hi Shakil with security";
	}
	
	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public Employee deleteEmployee(@PathVariable Long id) {
		return employeeService.deleteEmployee(id);
	}
	
//	@GetMapping
//	public List<Employee> getEmployees(@RequestHeader("Authorization") String authorization) {
//		return employeeService.getEmployees();
//	}
	
//	@PostMapping(value = "/createEmployee", consumes = "application/json", produces = "application/json")
//	public Employee addEmployee(@RequestBody Employee employee) {
//		return employeeService.addEmployee(employee);
//	}
	
}
