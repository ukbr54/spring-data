package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
