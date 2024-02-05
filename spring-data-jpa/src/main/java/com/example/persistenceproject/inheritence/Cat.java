package com.example.persistenceproject.inheritence;

import jakarta.persistence.Entity;

@Entity
public class Cat extends Animal{
    @Override
    public String makeNoise() {
        return "meow meow..";
    }
}
