package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {
}
