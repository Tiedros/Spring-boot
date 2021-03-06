package com.tiedros.springboot.cruddemo.dao;

import java.util.List;

import com.tiedros.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee employee);
	public void deleteById(int theId);
}
