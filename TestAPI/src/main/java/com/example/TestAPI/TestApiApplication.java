package com.example.TestAPI;

import com.example.TestAPI.model.Employee;
import com.example.TestAPI.repositary.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepo employeeRepo;
	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();

		employee.setFirstName("Malithi");
		employee.setLastName("Perera");
		employee.setEmailId("malithi@gmail.com");
		employeeRepo.save(employee);

	}
}
