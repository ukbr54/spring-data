package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserClient1 implements Runnable{

    private @Autowired CollegeManagementService collegeManagementService;

    @Override
    public void run() {
        Guide guide = collegeManagementService.findGuideById(2L);
        try {
            Thread thread = Thread.currentThread();
            thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        guide.setSalary("3000");
        System.out.println(Thread.currentThread().getName());
        collegeManagementService.updateGuide(guide);
    }
}
