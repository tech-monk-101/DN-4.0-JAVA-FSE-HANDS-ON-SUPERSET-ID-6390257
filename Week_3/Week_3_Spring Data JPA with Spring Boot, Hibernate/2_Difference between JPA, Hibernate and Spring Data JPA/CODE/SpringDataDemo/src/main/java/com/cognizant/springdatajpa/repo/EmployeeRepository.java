package com.cognizant.springdatajpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.springdatajpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
