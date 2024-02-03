package com.example.persistenceproject.service;

import com.example.persistenceproject.entity.User;
import com.example.persistenceproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class UserService {
    private @Autowired UserRepository userRepository;

    @Transactional
    public void persistUser(){
        User user1 = new User("john", LocalDate.of(2021, Month.AUGUST, 4), "john@somewhr.com", 1, true);
        User user2 = new User("jane", LocalDate.of(2019, Month.MARCH, 18), "jane@somewhrelse.com", 2, true);
        User user3 = new User("nicole", LocalDate.of(2017, Month.JULY, 21), "nicole@somewhr.com", 1, false);
        User user4 = new User("ravi", LocalDate.of(2018, Month.JUNE, 15), "ravi@somewhrelse.com", 1, false);
        User user5 = new User("alissa", LocalDate.of(2014, Month.APRIL, 5), "alissa@somewhr.com", 2, true);
        User user6 = new User("katie", LocalDate.of(2014, Month.APRIL, 5), "katie@somewhrelse.com", 3, true);

        userRepository.saveAll(List.of(user1,user2,user3,user4,user5,user6));
    }

    @Transactional
    public void deleteUsersByLevel(){
        Integer countOfDeletedUser = userRepository.deleteByLevel(1);
        System.out.println("countOfDeletedUser: "+countOfDeletedUser);
    }

    @Transactional
    public void deleteUsersInBulkByLevel(){
        Integer countOfDeletedUserInBulk = userRepository.deleteInBulkByLevel(2);
        System.out.println("countOfDeletedUserInBulk: "+countOfDeletedUserInBulk);
    }

    @Transactional
    public void updateInBulk(){
        Integer updatedUsers = userRepository.updateInBulk(LocalDate.of(2020, Month.JANUARY, 1));
        System.out.println("updatedUsers: "+updatedUsers);
    }
}
