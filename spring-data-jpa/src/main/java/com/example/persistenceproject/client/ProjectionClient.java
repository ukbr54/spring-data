package com.example.persistenceproject.client;

import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class ProjectionClient implements ApplicationRunner {

    private @Autowired CollegeManagementService collegeManagementService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        collegeManagementService.populateDb();
        collegeManagementService.displayNameAndSalaryOfFirst3GuidesBySalaryGreaterThan1000();
        collegeManagementService.displayNameAndSalaryOfStaffId();
    }
}
