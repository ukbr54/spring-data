package com.example.persistenceproject;

import com.example.persistenceproject.entity.User;
import com.example.persistenceproject.repository.UserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PagingAndSortingTest {

    private @Autowired UserRepository userRepository;

    //Page 1
    @Test
    public void testFindAllPage1Of3Users() {
        Page<User> page1Of3Users = userRepository.findAll(PageRequest.of(0, 3));
        List<User> users = page1Of3Users.getContent();
        assertEquals(3, users.size());
        assertEquals("nicole", users.get(2).getUsername());
    }

    //Page 2
    @Test
    public void testFindAllPage2Of3Users() {
        Page<User> page2Of3Users = userRepository.findAll(PageRequest.of(1, 3));
        List<User> users = page2Of3Users.getContent();

        assertEquals(3, users.size());
        assertEquals("katie", users.get(2).getUsername());
    }

    //Page 2, Sort by "level"
    @Test
    public void testFindAllPage2Of3UsersSortByLevel() {
        Page<User> page2Of3Users = userRepository.findAll(PageRequest.of(1, 3, Sort.by("level")));
        List<User> users = page2Of3Users.getContent();

        assertEquals(3, users.size());

        //User#2L, User#5L and User#7L are guaranteed to be in returned users, but their order is "not" guaranteed
        assertTrue( List.of(2L, 5L, 7L).containsAll( List.of(users.get(0).getId(), users.get(1).getId(), users.get(2).getId()) ) );
    }

    //Page 2, Sort by "level" and then by "id"
    @Test
    public void testFindAllPage2Of3UsersSortByLevelAndId() {
        Page<User> page2Of3Users = userRepository.findAll(PageRequest.of(1, 3, Sort.by("level").and(Sort.by("id"))));
        List<User> users = page2Of3Users.getContent();

        assertEquals(3, users.size());

        //User#2L, User#5L and User#7L are guaranteed to be in returned users, but their order "is also" guaranteed
        assertEquals(2L, users.get(0).getId());
        assertEquals(5L, users.get(1).getId());
        assertEquals(7L, users.get(2).getId());
    }

    //Page 2, Sort by "level" and then by "username"
    @Test
    public void testFindAllPage2Of3UsersSortByLevelAndUsername() {
        Page<User> page2Of3Users = userRepository.findAll(PageRequest.of(1, 3, Sort.by("level").and(Sort.by("username"))));
        List<User> users = page2Of3Users.getContent();

        assertEquals(3, users.size());
        assertEquals("alissa", users.get(0).getUsername());
        assertEquals("jane", users.get(1).getUsername());
        assertEquals("julius", users.get(2).getUsername());
    }

    @BeforeAll
    public void populateDb() {
        User user1 = new User("john", LocalDate.of(2021, Month.AUGUST, 4), "john@somewhr.com", 1, true);
        User user2 = new User("jane", LocalDate.of(2019, Month.MARCH, 18), "jane@somewhrelse.com", 2, true);
        User user3 = new User("nicole", LocalDate.of(2017, Month.JULY, 21), "nicole@somewhr.com", 1, false);
        User user4 = new User("ravi", LocalDate.of(2018, Month.JUNE, 15), "ravi@somewhrelse.com", 1, false);
        User user5 = new User("alissa", LocalDate.of(2014, Month.APRIL, 5), "alissa@somewhr.com", 2, true);
        User user6 = new User("katie", LocalDate.of(2014, Month.APRIL, 5), "katie@somewhrelse.com", 3, true);
        User user7 = new User("julius", LocalDate.of(2021, Month.FEBRUARY, 9), "julius@somewhrelse.com", 2, true);
        User user8 = new User("jyotsna", LocalDate.of(2020, Month.DECEMBER, 11), "jyotsna@somewhrelse.com", 3, true);
        User user9 = new User("mary", LocalDate.of(2020, Month.MAY, 14), "mary@somewhr.com", 4, false);
        User user10 = new User("judy", LocalDate.of(2015, Month.JANUARY, 8), "judy@somewhrelse.com", 3, true);

        userRepository.saveAll( List.of(user1, user2, user3, user4, user5, user6,user7,user8,user9,user10) );
    }

    @AfterAll
    public void dePopulateDb() {
        userRepository.deleteAll();
    }
}
