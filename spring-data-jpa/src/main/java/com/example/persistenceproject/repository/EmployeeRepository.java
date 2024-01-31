package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
