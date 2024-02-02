package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.repository.GuideRepository;
import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Component
//@Order(2)
public class OptimisticLockingClient implements ApplicationRunner {

    @Autowired
    private UserClient1 user1Client;

    @Autowired
    private UserClient2 user2Client;

    @Override
    public void run(ApplicationArguments args) {

        ExecutorService executor = Executors.newFixedThreadPool (2);
        executor.execute(user1Client);
        executor.execute(user2Client);

        executor.shutdown();

    }
}
