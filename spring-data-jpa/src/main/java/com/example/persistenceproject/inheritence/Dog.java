package com.example.persistenceproject.inheritence;

import jakarta.persistence.Entity;

@Entity
public class Dog extends Animal{

    @Override
    public String makeNoise() {
        return "woof woof..";
    }
}
