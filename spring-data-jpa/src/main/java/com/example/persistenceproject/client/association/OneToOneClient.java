package com.example.persistenceproject.client.association;

import com.example.persistenceproject.entity.Customer;
import com.example.persistenceproject.entity.Passport;
import com.example.persistenceproject.repository.CustomerRepository;
import com.example.persistenceproject.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
public class OneToOneClient implements ApplicationRunner {

    private @Autowired CustomerRepository customerRepository;
    private @Autowired PassportRepository passportRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Passport passport = new Passport("925076473","GBR");
        Customer customer = new Customer("Nicole Scott","ns27@sumwhr.com",passport);

        customerRepository.save(customer);

        Customer customer1 = customerRepository.findById(1L).get();
    }
}
