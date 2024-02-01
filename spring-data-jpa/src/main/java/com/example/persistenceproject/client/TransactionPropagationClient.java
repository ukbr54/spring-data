package com.example.persistenceproject.client;

import com.example.persistenceproject.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class TransactionPropagationClient implements ApplicationRunner {

    private @Autowired ItemService itemService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        itemService.persistAnItem();
    }
}
