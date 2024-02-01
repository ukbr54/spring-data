package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter @Getter @NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;
    @Column(name = "scheduled_at")
    private LocalDateTime scheculedAt;

    public Ticket(String origin, String destination, LocalDateTime scheculedAt) {
        this.origin = origin;
        this.destination = destination;
        this.scheculedAt = scheculedAt;
    }
}
