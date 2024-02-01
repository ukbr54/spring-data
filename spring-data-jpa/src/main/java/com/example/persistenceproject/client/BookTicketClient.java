package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Ticket;
import com.example.persistenceproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

//@Component
public class BookTicketClient implements ApplicationRunner {

    private @Autowired TicketService ticketService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Ticket ticket =
                new Ticket("Bus Stop 1","Bus Stop 2", LocalDateTime.of(2024, Month.FEBRUARY,02,12,00));
        ticketService.bookTicket(ticket);
    }
}
