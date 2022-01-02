package com.example.proiectjavacoolapp.repository;

import com.example.proiectjavacoolapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
