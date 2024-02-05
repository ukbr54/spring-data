package com.example.persistenceproject.projection;

import org.springframework.beans.factory.annotation.Value;

public interface GuideNameSalary {

    String getName();
    Integer getSalary();

    //Query is not optimized - the whole data is loaded in this case
    @Value("#{target.name}\t#{target.salary}")
    String getInfo();
}
