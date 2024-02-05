package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter @NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "actors",cascade = CascadeType.PERSIST)
    private Set<Movie> movies = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
        movie.getActors().add(this);
    }

    public void removeMovie(Movie movie){
        this.movies.remove(movie);
        movie.getActors().remove(this);
    }
}
