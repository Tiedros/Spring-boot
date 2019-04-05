package com.tiedros.springboot.ThymeleafDemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tiedros.springboot.ThymeleafDemo.entity.Employee;
import com.tiedros.springboot.ThymeleafDemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	private EmployeeService employeeService;
	
	// constructor injection 
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	
	
	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		// add employee list to the spring model
		theModel.addAttribute("employees",theEmployees);
		
		return "employees/list-employees";
	}
	
	// add form for user
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind data
		Employee theEmployee= new Employee();
		theModel.addAttribute("employee",theEmployee);
		
		return "employees/employee-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel) {
		
		// get the employee from DB
		Employee theEmployee=employeeService.findById(theId);
		
		// add the employee to Model attribute for pre-populate
		theModel.addAttribute("employee",theEmployee);
		
		// send over to the form
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		// save employee
		employeeService.save(theEmployee);
	// use redirect to prevent duplicate submission
		return "redirect:/employees/list";
	}
	
	// add mapping to delete employee
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		// delete employee
		employeeService.deleteById(theId);
		
		// redirect to employe list
		return "redirect:/employees/list";
	}
	
}
