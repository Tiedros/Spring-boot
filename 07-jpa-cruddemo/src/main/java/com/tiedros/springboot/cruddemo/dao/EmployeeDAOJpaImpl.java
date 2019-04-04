package com.tiedros.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tiedros.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define a field for entity manager
	private EntityManager entityManager;
	
	// constructor injection 
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	@Override
	public List<Employee> findAll() {
		
		// create query
		Query theQuery=entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees=theQuery.getResultList();
		
		// return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get  employee
		Employee theEmployee=entityManager.find(Employee.class, theId);
		// return employee
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		// save or update the employee
		Employee dbEmployee=entityManager.merge(employee);
		
		// update with id from db ... so that we can get the generated id from db
		employee.setId(dbEmployee.getId());
		
		
		
		

	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery =entityManager.createQuery(
				"delete from Employee where id=:employeeId" );
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();

	}

}
