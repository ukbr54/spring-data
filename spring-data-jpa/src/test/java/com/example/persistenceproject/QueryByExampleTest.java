package com.example.persistenceproject;

import com.example.persistenceproject.entity.Employee;
import com.example.persistenceproject.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QueryByExampleTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testQueryByExample1() {
        Employee user = new Employee();
        user.setLastname("Smith");
        user.setLevel(2);

        Example<Employee> example = Example.of(user);
        List<Employee> matchingUsers = employeeRepository.findAll(example);
        System.out.println(matchingUsers);
        assertEquals(2, matchingUsers.size());
    }

    @Test
    public void testQueryByExample2() {
        Employee user = new Employee();
        user.setLastname("Smith");

        Example<Employee> example = Example.of(user);
        List<Employee> matchingUsers = employeeRepository.findAll(example);
        System.out.println(matchingUsers);
        assertEquals(0, matchingUsers.size());
    }

    @Test
    public void testQueryByExample3() {
        Employee user = new Employee();
        user.setLastname("Smith");

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("level");
        Example<Employee> example = Example.of(user, matcher);
        List<Employee> matchingUsers = employeeRepository.findAll(example);
        System.out.println(matchingUsers);
        assertEquals(3, matchingUsers.size());
    }

    @Test
    public void testQueryByExample4() {
        Employee user = new Employee();
        user.setFirstname("s");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example<Employee> example = Example.of(user, matcher);
        List<Employee> matchingUsers = employeeRepository.findAll(example);
        System.out.println(matchingUsers);
        assertEquals(2, matchingUsers.size());
    }

    @Test
    public void testQuestion1() {
        Employee user = new Employee();
        user.setFirstname("s");
        user.setEmail("@else.com");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("level")
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example<Employee> example = Example.of(user, matcher);
        List<Employee> matchingUsers = employeeRepository.findAll(example);
        System.out.println(matchingUsers);
        assertEquals(0, matchingUsers.size());
    }

    @Test
    public void testQueryByExample5() {
        Employee user = new Employee();
        user.setFirstname("s");
        user.setEmail("@else.com");

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withIgnorePaths("level")
                .withMatcher("firstname", match -> match.startsWith())
                .withMatcher("email", match -> match.endsWith())
                .withIgnoreCase();
        Example<Employee> example = Example.of(user, matcher);
        List<Employee> matchingUsers = employeeRepository.findAll(example);
        System.out.println(matchingUsers);
        assertEquals(1, matchingUsers.size());
    }

    @BeforeAll
    public void populateDb() {
        Employee user1 = new Employee("gillamy01", "Amy", "Gill", "amy@somewhrelse.com", 1);
        Employee user2 = new Employee("smithjohn02", "John", "Smith", "john@somewhr.com", 2);
        Employee user3 = new Employee("lawsonmike03", "Mike", "Lawson", "mike@else.com", 3);
        Employee user4 = new Employee("lambian03", "Ian", "Lamb", "ian@somewhr.com", 3);
        Employee user5 = new Employee("bailektora02", "Tora", "Bailek", "tora@somewhr.com", 2);
        Employee user6 = new Employee("smithsadie01", "Sadie", "Smith", "sadie@somewhrelse.com", 1);
        Employee user7 = new Employee("ambrizsharon01", "Sharon", "Ambriz", "sharon@else.com", 1);
        Employee user8 = new Employee("singhrahul02", "Rahul", "Singh", "rahul@somewhr.com", 2);
        Employee user9 = new Employee("smithjoe02", "Joe", "Smith", "joe@else.com", 2);
        Employee user10 = new Employee("johnsonleo03", "Leo", "Johnson", "leo@somewhr.com", 3);
        Employee user11 = new Employee("leebrett04", "Brett", "Lee", "brett@else.com", 4);

        employeeRepository.saveAll( List.of(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11 ) );
    }

    @AfterAll
    public void dePopulateDb() {
        employeeRepository.deleteAll();
    }
}
