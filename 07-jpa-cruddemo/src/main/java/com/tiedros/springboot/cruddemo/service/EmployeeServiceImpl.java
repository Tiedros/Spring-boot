package com.tiedros.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiedros.springboot.cruddemo.dao.EmployeeDAO;
import com.tiedros.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO employeeDAO;
	
	// Constructor Injection
	
	// @Qualifier("employeeDAOJpaImpl") will force to user the jpa bean
	//otherwise it will fail to to start 
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl")EmployeeDAO theEmployeeDAO) {
		this.employeeDAO=theEmployeeDAO;
	}
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}
	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return employeeDAO.findById(theId);
	}
	@Override
	@Transactional
	public void save(Employee employee) {
	 employeeDAO.save(employee);
		
	}
	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
	}

}
