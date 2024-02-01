package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserClient2 implements Runnable{
    private @Autowired CollegeManagementService collegeManagementService;

    @Override
    public void run() {
        Guide guide = collegeManagementService.findGuideById(2L);
        guide.setSalary("4000");
        System.out.println(Thread.currentThread().getName());
        collegeManagementService.updateGuide(guide);
    }
}
