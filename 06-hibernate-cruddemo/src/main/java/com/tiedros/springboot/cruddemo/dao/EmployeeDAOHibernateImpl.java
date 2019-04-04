package com.tiedros.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.tiedros.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// get current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		
		// create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		// execute query and get results
		List<Employee> employees=theQuery.getResultList();
		// return results
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		// get current hibernate session 
		Session session=entityManager.unwrap(Session.class);
		
		// get employee
		Employee theEmployee=session.get(Employee.class, theId);
		
		// return employee
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		// get current hibernate session
		Session session= entityManager.unwrap(Session.class);
		
		// save employee
		 session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(int theId) {
		
		// get current hibernate session 
		Session session=entityManager.unwrap(Session.class);
		
		// delete employee with primary key
		Query theQuery=session.createQuery(
				"delete from Employee where id=:employeeId"
				);
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

	

}
