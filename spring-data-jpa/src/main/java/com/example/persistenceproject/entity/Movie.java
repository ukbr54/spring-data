package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter @NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    private Set<Actor> actors = new HashSet<>();

    public Movie(String name) {
        this.name = name;
    }
}
