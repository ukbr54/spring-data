package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Component;

@Component
public class UserClient1 implements Runnable{

    private @Autowired CollegeManagementService collegeManagementService;

    @Override
    public void run() {
        Guide guide = collegeManagementService.findGuideById(2L);
        guide.setSalary(3000);
        try {
            collegeManagementService.updateGuide(guide);
        } catch (ObjectOptimisticLockingFailureException e) {
            e.printStackTrace();
            System.out.println("\033[0;31m" + "The Guide#2 was updated by some other user, while you were occupied with something else.");
        }
    }
}
