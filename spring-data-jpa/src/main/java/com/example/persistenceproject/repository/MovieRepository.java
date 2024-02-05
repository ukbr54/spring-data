package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
