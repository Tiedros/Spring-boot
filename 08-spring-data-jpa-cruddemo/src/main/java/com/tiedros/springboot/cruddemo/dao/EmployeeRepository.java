package com.tiedros.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiedros.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
