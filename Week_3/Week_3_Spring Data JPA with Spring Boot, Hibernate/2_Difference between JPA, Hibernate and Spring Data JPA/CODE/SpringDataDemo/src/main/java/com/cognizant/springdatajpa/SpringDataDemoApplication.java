package com.cognizant.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.springdatajpa.entity.Employee;
import com.cognizant.springdatajpa.service.EmployeeService;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplication.class, args);
    }
    
    @Override
    public void run(String... args) {
        Employee emp = new Employee();
        emp.setName("Ruchika Bhati");
        emp.setDepartment("Contractor");
        service.addEmployee(emp);
    }
}
