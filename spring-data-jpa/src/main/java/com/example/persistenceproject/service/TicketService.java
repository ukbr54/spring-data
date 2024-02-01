package com.example.persistenceproject.service;

import com.example.persistenceproject.entity.Ticket;
import com.example.persistenceproject.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private @Autowired TicketRepository ticketRepository;

    @Transactional
    public void bookTicket(Ticket ticket) throws InterruptedException {
        Thread.sleep(40000);
        ticketRepository.save(ticket);
        //throw new RuntimeException("Payment Failed");
        Thread.sleep(40000);
    }
}
