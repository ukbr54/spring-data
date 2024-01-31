package com.example.persistenceproject.repository;

import com.example.persistenceproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    //Is, Equals
    User findByUsername(String username);
    User findByUsernameIs(String username);
    User findByUsernameEquals(String username);

    //OrderBy, Asc, Desc
    List<User> findAllByOrderByRegistrationDate();
    List<User> findAllByOrderByRegistrationDateAsc();
    List<User> findAllByOrderByRegistrationDateDesc();

    //Question 1
    List<User> findByRegistrationDateOrderByUsername(LocalDate registrationDate);

    //Between, Before, After
    List<User> findByRegistrationDateBetween(LocalDate start, LocalDate end);
    List<User> findByRegistrationDateBefore(LocalDate before);
    List<User> findByRegistrationDateAfter(LocalDate after);

    //In, NotIn
    List<User> findByLevelIn(Collection<Integer> levels);
    List<User> findByLevelNotIn(Collection<Integer> levels);

    //LessThan, LessThanEqual, GreaterThan, GreaterThanEqual
    List<User> findByLevelLessThan(Integer level);
    List<User> findByLevelLessThanEqual(Integer level);
    List<User> findByLevelGreaterThan(Integer level);
    List<User> findByLevelGreaterThanEqual(Integer level);

    //StartingWith, EndingWith, Containing
    List<User> findByUsernameStartingWith(String start);
    List<User> findByUsernameEndingWith(String end);
    List<User> findByUsernameContaining(String contains);

    //IgnoreCase
    List<User> findByUsernameContainingIgnoreCase(String contains);

    //IsNull, Null, IsNotNull, NotNull
    List<User> findByUsernameIsNull();
    List<User> findByUsernameNull();
    List<User> findByUsernameIsNotNull();
    List<User> findByUsernameNotNull();

    //IsNot, Not
    List<User> findByLevelIsNot(Integer level);
    List<User> findByLevelNot(Integer level);

    //True, False
    List<User> findByIsActiveTrue();
    List<User> findByIsActiveFalse();

    //Question 2 Answer 1
    List<User> findFirst2ByIsActiveAndUsernameEndingWith(Boolean isActive, String username);

    //Question 2 Answer 2
    List<User> findFirst2ByIsActiveTrueAndUsernameEndingWith(String username);

    //find all users with their level ordered in descending order
    List<User> findByOrderByLevelDesc();

    //find just first 2 users with their level ordered in descending order
    List<User> findFirst2ByOrderByLevelDesc();
    List<User> findTop2ByOrderByLevelDesc();

    //find just first user from users ordered by their level in descending order
    User findFirstByOrderByLevelDesc();
    User findTopByOrderByLevelDesc();

    //find all users who are either inactive or 1st
    List<User> findByIsActiveTrueOrLevel(Integer level);

    //find all users whose email contains the string "else" in it
    List<User> findByEmailContaining(String contain);


}
