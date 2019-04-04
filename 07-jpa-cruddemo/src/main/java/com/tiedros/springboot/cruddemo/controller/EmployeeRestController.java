package com.tiedros.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiedros.springboot.cruddemo.entity.Employee;
import com.tiedros.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	// Constructor injection
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}

	// expose "/employee" and return list of employees
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeService.findAll();
	}
	
	// add mapping for GET "/employee/{employeeId}"
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee= employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee id not found - "+ employeeId);
		}
		return theEmployee;
	}
	
	// add mapping for POST "/employee" to add a new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		// also in case they pass id in JSON pay load 
		// lets force it to zero. this is to force save ... instead of update
		
			employee.setId(0);
		 employeeService.save(employee);
		 return employee;
		
	}
	
	// add mapping for PUT "/employees" updating existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	// add mapping for delete "/employees/{employeeId}"
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee theEmployee= employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Employee  not found id - " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Successfully deleted id - " + employeeId;
	}
}







