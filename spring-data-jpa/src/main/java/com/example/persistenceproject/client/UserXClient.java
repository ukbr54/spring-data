package com.example.persistenceproject.client;

import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserXClient implements Runnable {

	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run() {
		
		cMService.prepareNameAndSalaryReportOfAllGuides();
		
	}
	
}
