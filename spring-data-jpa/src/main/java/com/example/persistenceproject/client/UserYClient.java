package com.example.persistenceproject.client;

import com.example.persistenceproject.service.CollegeManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Component;


//@Component
public class UserYClient implements Runnable {

	@Autowired
	private CollegeManagementService cMService;

	@Override
	public void run() {
		
		try {
			cMService.raiseSalaryOfGuide(3L, 4000);
		} catch (PessimisticLockingFailureException e) {
			System.out.println("[3, 'David Crow', 3000, '2000DO10777'] is locked by tx 1 and can not be updated by tx 2");
		}

	}
	
}
