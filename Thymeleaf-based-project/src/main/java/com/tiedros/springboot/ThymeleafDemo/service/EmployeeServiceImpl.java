package com.tiedros.springboot.ThymeleafDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiedros.springboot.ThymeleafDemo.dao.EmployeeRepository;
import com.tiedros.springboot.ThymeleafDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepository;
	
	// Constructor Injection
	
	// @Qualifier("employeeDAOJpaImpl") will force to user the jpa bean
	//otherwise it will fail to to start 
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository=theEmployeeRepository;
	}
	@Override
	//@Transactional no need. Since JPA repository gives this out of the box
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc(); 
	}
	@Override
	//@Transactional no need. Since JPA repository gives this out of the box
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee thEmployee=null;
		if(result.isPresent()) {
			thEmployee=result.get();
		}else {
			// we didn't find the employee
			throw new RuntimeException("Didn't find the employee id- "+ theId);
		}
		return thEmployee;
	}
	@Override
	//@Transactional no need. Since JPA repository gives this out of the box
	public void save(Employee employee) {
		employeeRepository.save(employee);
		
	}
	@Override
	//@Transactional no need. Since JPA repository gives this out of the box
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

}
