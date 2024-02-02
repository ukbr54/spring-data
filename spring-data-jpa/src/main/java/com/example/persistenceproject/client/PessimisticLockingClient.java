package com.example.persistenceproject.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class PessimisticLockingClient implements ApplicationRunner {
	
	@Autowired
	private UserXClient userXClient;
	
	@Autowired
	private UserYClient userYClient;

	@Override
	public void run(ApplicationArguments args) {	
		
		ExecutorService executor = Executors.newFixedThreadPool (2);
    	executor.execute(userXClient);
    	executor.execute(userYClient);
    	
    	executor.shutdown();
         
	}

}