package com.example.persistenceproject.client.association;

import com.example.persistenceproject.entity.Actor;
import com.example.persistenceproject.entity.Movie;
import com.example.persistenceproject.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ManyToManyClient implements ApplicationRunner {

    private @Autowired ActorRepository actorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie movie1 = new Movie("American Hustle");
        Movie movie2 = new Movie("The Prestige");

        Actor actor1 = new Actor("Christian Bale");
        Actor actor2 = new Actor("Hugh Jackman");

        actor1.addMovie(movie1);
        actor1.addMovie(movie2);

        actor2.addMovie(movie2);

        actorRepository.save(actor1);
        actorRepository.save(actor2);
    }
}
