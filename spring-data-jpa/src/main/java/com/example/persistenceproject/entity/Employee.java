package com.example.persistenceproject.entity;

import com.example.persistenceproject.dto.EmployeeDto;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery( name = "CountByDepartmentProcedure",  procedureName = "count_employee_by_department",
                parameters = { @StoredProcedureParameter( name = "dept", type = String.class, mode = ParameterMode.IN),
                               @StoredProcedureParameter( name = "count", type = Integer.class, mode = ParameterMode.OUT)
                }
        ),
        @NamedStoredProcedureQuery(name = "FindByDepartmentProcedure", procedureName = "find_employee_by_department", resultClasses = Employee.class,
                parameters = { @StoredProcedureParameter( name = "dept", type = String.class, mode = ParameterMode.IN) }
        ),
        @NamedStoredProcedureQuery(name = "FindNameAndSalaryByDepartmentProcedure", procedureName = "find_name_and_salary_by_department", resultSetMappings = "EmployeeDtoMapping",
                parameters = {@StoredProcedureParameter(name = "dept", type = String.class, mode = ParameterMode.IN)}
        )
})
@SqlResultSetMapping(name = "EmployeeDtoMapping", classes = @ConstructorResult(
                targetClass = EmployeeDto.class,
                columns = {@ColumnResult(name = "name"), @ColumnResult(name = "salary")}
        )
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private int level;
    private Integer Salary;
    private String department;

    public Employee(String username, Integer salary, String department) {
        this.username = username;
        Salary = salary;
        this.department = department;
    }

    public Employee() {}
    public Employee(String username, String firstname, String lastname, String email, int level) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.level = level;
    }



    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
                + ", email=" + email + ", level=" + level + "]";
    }
}
