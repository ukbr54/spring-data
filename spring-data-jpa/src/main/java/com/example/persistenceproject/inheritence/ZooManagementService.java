package com.example.persistenceproject.inheritence;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZooManagementService {

    private @Autowired CatRepository catRepository;
    private @Autowired DogRepository dogRepository;
    private @Autowired AnimalRepository animalRepository;

    @Transactional
    public void persistingACatAndADog(){
        Cat cat = new Cat();
        cat.setName("Lucy");

        Dog dog = new Dog();
        dog.setName("Oliver");

        catRepository.save(cat);
        dogRepository.save(dog);
    }

    @Transactional
    public void findAllAnimal(){
        List<Animal> animals = animalRepository.findAll();
        animals.forEach(System.out::println);
    }
}
