package com.example.persistenceproject.client;

import com.example.persistenceproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ModifyingClient implements ApplicationRunner {

    private @Autowired UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.persistUser();

        userService.deleteUsersByLevel();

        userService.deleteUsersInBulkByLevel();

        userService.updateInBulk();
    }
}
