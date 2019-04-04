package com.tiedros.springboot.ThymeleafDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tiedros.springboot.ThymeleafDemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> theEmployees;
	
	// load employee data
	
	@PostConstruct
	private void loadData() {
	// create employees
		Employee emp1= new Employee(1, "Leslie", "Andrews", "leslie@tiedros.com");
		Employee emp2= new Employee(2, "Emma", "Baumgarten", "emma@@tiedros.com");
		Employee emp3= new Employee(3, "Avani", "Gupta", "avani@tiedros.com");
		
		
		// create the list
		theEmployees= new ArrayList<>();
		
		// add to the list
		theEmployees.add(emp1);
		theEmployees.add(emp2);
		theEmployees.add(emp3);
	}
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		// add employee list to the spring model
		theModel.addAttribute("employees",theEmployees);
		
		return "list-employees";
	}
}
