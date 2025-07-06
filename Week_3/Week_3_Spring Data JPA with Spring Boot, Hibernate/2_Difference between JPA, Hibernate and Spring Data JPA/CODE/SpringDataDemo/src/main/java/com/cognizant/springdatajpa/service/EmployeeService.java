package com.cognizant.springdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springdatajpa.entity.Employee;
import com.cognizant.springdatajpa.repo.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void addEmployee(Employee emp) {
        repo.save(emp);
    }
}
