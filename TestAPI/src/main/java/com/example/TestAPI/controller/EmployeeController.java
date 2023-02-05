package com.example.TestAPI.controller;

import com.example.TestAPI.exception.ResourceNotFound;
import com.example.TestAPI.model.Employee;
import com.example.TestAPI.repositary.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    //get all employee
    @GetMapping
    public List<Employee> getEmployee(){
        return employeeRepo.findAll();

    }
    //create a employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

    //search  employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getbyId(@PathVariable long id){
        Employee employee=employeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee not found"+id));
        return ResponseEntity.ok(employee);
    }

    //update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee>  updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Employee updateEmployee=employeeRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Employee not found"+id));
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmailId(employee.getEmailId());

        return  ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("{id}")
    //delete Employee
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFound("Employee not exist"));
        employeeRepo.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
