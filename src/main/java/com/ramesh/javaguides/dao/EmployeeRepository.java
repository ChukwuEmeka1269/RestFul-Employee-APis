package com.ramesh.javaguides.dao;

import com.ramesh.javaguides.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
