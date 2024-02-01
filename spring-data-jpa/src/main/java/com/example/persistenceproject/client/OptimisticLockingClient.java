package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.repository.GuideRepository;
import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class OptimisticLockingClient implements ApplicationRunner {

    private @Autowired GuideRepository guideRepository;

    private @Autowired UserClient1 client1;
    private @Autowired UserClient2 client2;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Guide guide = new Guide("2024FEB001","Mike Lawson","1000");
        Guide guide1 = new Guide("2024MAR002","Mike Lawson","1000");
        Guide guide2 = new Guide("2024FEB002","Mike Lawson","1000");

        guideRepository.saveAll(Arrays.asList(guide,guide1,guide2));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(client1);
        executorService.execute(client2);

        executorService.shutdown();
    }
}
