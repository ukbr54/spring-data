package com.example.persistenceproject;

import com.example.persistenceproject.entity.Ticket;
import com.example.persistenceproject.repository.TicketRepository;
import com.example.persistenceproject.service.TicketService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
public class TransactionTest {

    private @Autowired TicketService ticketService;
    private @Autowired TicketRepository ticketRepository;

    @Test
    public void testBookingTicket(){
        try{
            Ticket ticket =
                    new Ticket("Bus Stop 1","Bus Stop 2", LocalDateTime.of(2024, Month.FEBRUARY,02,12,00));
            ticketService.bookTicket(ticket);
        }catch (Exception e){
            System.out.println("======> "+e.getMessage());
        }finally {
            Assertions.assertThat(ticketRepository.findAll()).isEmpty();
        }
    }
}
