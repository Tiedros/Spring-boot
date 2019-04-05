package com.tiedros.springboot.ThymeleafDemo.service;

import java.util.List;

import com.tiedros.springboot.ThymeleafDemo.entity.Employee;



public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee employee);
	public void deleteById(int theId);
}
