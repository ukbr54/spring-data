package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @NoArgsConstructor @ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    //owner-end
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passport_id",unique = true)
    private Passport passport;

    public Customer(String name, String email, Passport passport) {
        this.name = name;
        this.email = email;
        this.passport = passport;
    }
}
