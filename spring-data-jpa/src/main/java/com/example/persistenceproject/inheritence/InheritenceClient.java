package com.example.persistenceproject.inheritence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InheritenceClient implements ApplicationRunner {

    private @Autowired ZooManagementService zooManagementService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        zooManagementService.persistingACatAndADog();
        zooManagementService.findAllAnimal();
    }
}
