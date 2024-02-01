package com.example.persistenceproject.service;

import com.example.persistenceproject.entity.Item;
import com.example.persistenceproject.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class ItemService {

    private @Autowired ItemRepository itemRepository;
    private @Autowired LoggingService loggingService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void persistAnItem(){
        Item item = new Item("Item1", LocalDate.of(2022,5,1),29);
        itemRepository.save(item);

        loggingService.logAMessage("Adding item with name "+item.getName());
    }
}
