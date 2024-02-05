package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
