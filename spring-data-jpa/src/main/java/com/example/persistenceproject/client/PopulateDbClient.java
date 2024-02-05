package com.example.persistenceproject.client;


import com.example.persistenceproject.entity.Guide;
import com.example.persistenceproject.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(1)
public class PopulateDbClient implements ApplicationRunner {

    @Autowired
    private GuideRepository guideRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //pre-populating db with 3 guides
        Guide guide1 = new Guide("2000MO10789", "Mike Lawson", 1000);
        Guide guide2 = new Guide("2000IM10901", "Ian Lamb", 2500);
        Guide guide3 = new Guide("2000DO10777", "David Crow", 3000);

        guideRepository.save(guide1);
        guideRepository.save(guide2);
        guideRepository.save(guide3);

    }

}
