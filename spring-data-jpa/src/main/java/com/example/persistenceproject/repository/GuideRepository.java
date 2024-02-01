package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide,Long> {
}
