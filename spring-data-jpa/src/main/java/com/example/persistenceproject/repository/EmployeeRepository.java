package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.Employee;
import com.example.persistenceproject.projection.EmployeeNameSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Procedure(procedureName = "count_employee_by_department")
    Integer foo(@Param("p_dept") String dept);

    @Procedure(procedureName = "find_employee_by_department")
    List<Employee> bar(@Param("p_dept") String dept);

    @Procedure(procedureName = "find_name_and_salary_by_department")
    List<EmployeeNameSalary> zar(@Param("p_dept") String dept);
}
