package com.ramesh.javaguides.services;

import com.ramesh.javaguides.models.Employee;

import java.util.List;

public interface EmployeeServices {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployeeDetails(Employee employee, Long id);
    String deleteEmployee(Long id);

    String deleteAllEmployees();
}
