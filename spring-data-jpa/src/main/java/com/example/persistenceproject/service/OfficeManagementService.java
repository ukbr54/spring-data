package com.example.persistenceproject.service;

import com.example.persistenceproject.dto.EmployeeDto;
import com.example.persistenceproject.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OfficeManagementService {
    @Autowired
    private EntityManager em;

    @Transactional
    public void prepopulatingDb() {
        Employee emp1 = new Employee("Mark Young", 5000, "Engineering");
        Employee emp2 = new Employee("Olivia Goy", 4500, "Accounting");
        Employee emp3 = new Employee("Joana Tom", 5500, "QA");
        Employee emp4 = new Employee("Alicia Nimar", 5000, "Engineering");
        Employee emp5 = new Employee("Katy Loin", 4500, "Engineering");
        Employee emp6 = new Employee("Rahul Singh", 4500, "Engineering");

        em.persist(emp1);
        em.persist(emp2);
        em.persist(emp3);
        em.persist(emp4);
        em.persist(emp5);
        em.persist(emp6);
    }

    @Transactional
    public void countEmployeeByDepartment() {
        StoredProcedureQuery q = em.createNamedStoredProcedureQuery("CountByDepartmentProcedure");
        q.setParameter("dept", "Engineering");
        q.execute();
        Integer count = (Integer) q.getOutputParameterValue("count");
        System.out.println("count: " + count);
    }

    @Transactional
    public void findEmployeeByDepartment() {
        StoredProcedureQuery q = em.createNamedStoredProcedureQuery("FindByDepartmentProcedure");
        q.setParameter("dept", "Engineering");
        q.execute();
        List<Employee> empList = q.getResultList();
        for (Employee employee : empList) {
            System.out.println(employee);
        }
    }

    @Transactional
    public void findNameAndSalaryeByDepartment() {
        StoredProcedureQuery q = em.createNamedStoredProcedureQuery("FindNameAndSalaryByDepartmentProcedure");
        q.setParameter("dept", "Engineering");
        q.execute();
        List<EmployeeDto> employeeDtoList = q.getResultList();
        for (EmployeeDto employeeDto : employeeDtoList) {
            System.out.println("Name: " + employeeDto.getName() + ", Salary: " + employeeDto.getSalary());
        }
    }
}
