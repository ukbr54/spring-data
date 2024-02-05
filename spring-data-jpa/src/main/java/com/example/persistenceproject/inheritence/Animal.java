package com.example.persistenceproject.inheritence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
@Setter @Getter @NoArgsConstructor
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public abstract String makeNoise();

    @Override
    public String toString() {
        return name + " making " + makeNoise() + " noises";
    }
}
