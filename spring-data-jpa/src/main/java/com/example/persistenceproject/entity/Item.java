package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter @Getter @NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    private Integer price;

    public Item(String name, LocalDate creationDate, Integer price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }
}
