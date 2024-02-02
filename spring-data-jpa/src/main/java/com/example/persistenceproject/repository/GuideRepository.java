package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Guide;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GuideRepository extends JpaRepository<Guide,Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select guide.name, guide.salary from Guide guide")
    List<Object[]> getNameAndSalaryOfAll();

    @Query("select sum(guide.salary) from Guide guide")
    Long calculateSumOfAllSalaries();

    @Transactional
    @Modifying
    @Query("update Guide guide set guide.salary = guide.salary * 2")
    Integer doubleSalaryOfAll();
}
