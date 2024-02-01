package com.example.persistenceproject.service;

import com.example.persistenceproject.entity.Log;
import com.example.persistenceproject.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoggingService {

    private @Autowired LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void logAMessage(String logMessage){
        Log log = new Log(logMessage);
        logRepository.save(log);
    }
}
