package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.projection.GuideNameSalary;
import com.example.persistenceproject.projection.GuideNativeProjection;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide,Long> {

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("select guide.name, guide.salary from Guide guide")
    List<Object[]> getNameAndSalaryOfAll();

    @Query("select sum(guide.salary) from Guide guide")
    Long calculateSumOfAllSalaries();

    @Transactional
    @Modifying
    @Query("update Guide guide set guide.salary = guide.salary * 2")
    Integer doubleSalaryOfAll();

    List<GuideNameSalary> findFirst3BySalaryGreaterThan(Integer salary);

    @Query(value = "select g.name,g.salary from Guide g where g.staff_id like '%2%'",nativeQuery = true)
    List<GuideNativeProjection> findByStaffId();

    @Override
    @EntityGraph(value = "Guide.students",type = EntityGraph.EntityGraphType.LOAD)
    //@EntityGraph(attributePaths = {"students"},type = EntityGraph.EntityGraphType.LOAD)
    Optional<Guide> findById(Long id);
}
