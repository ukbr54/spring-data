package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}
