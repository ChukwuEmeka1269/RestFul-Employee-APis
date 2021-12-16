package com.ramesh.javaguides.services.serviceImpl;

import com.ramesh.javaguides.dao.EmployeeRepository;
import com.ramesh.javaguides.exceptions.ResourceNotFoundException;
import com.ramesh.javaguides.models.Employee;
import com.ramesh.javaguides.services.EmployeeServices;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeServices {


    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        if(employeeList.isEmpty()){
            throw new IllegalStateException("Employee list is empty. Create new employees.");
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "Id", id)
        );
    }

    @Override
    @Transactional
    public Employee updateEmployeeDetails(Employee employee, Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee", "Id", id)
        );
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

//        employeeRepository.save(existingEmployee); at transactional helps to save the data automatically

        return existingEmployee;
    }

    @Override
    public String deleteEmployee(Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id)
        );
        employeeRepository.delete(existingEmployee);
        return "Employee with Id: " + id + " has been deleted successfully.";
    }

    @Override
    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "Employee List has been successfully deleted";
    }


}
