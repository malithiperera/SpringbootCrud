package com.example.TestAPI.repositary;

import com.example.TestAPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    //all the crud database methods here

}
