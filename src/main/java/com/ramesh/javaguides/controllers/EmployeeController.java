package com.ramesh.javaguides.controllers;

import com.ramesh.javaguides.models.Employee;
import com.ramesh.javaguides.services.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeServices.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeServices.getAllEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(employeeServices.getEmployeeById(id), HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                   @RequestBody Employee employee){
        return ResponseEntity.ok(employeeServices.updateEmployeeDetails(employee, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        return ResponseEntity.ok(employeeServices.deleteEmployee(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllEmployee(){
        return ResponseEntity.ok(employeeServices.deleteAllEmployees());
    }
}
