package com.example.persistenceproject.projection;

import org.springframework.beans.factory.annotation.Value;

public interface GuideNativeProjection {

    @Value("#{target.name}\t#{target.salary}")
    String getInfo();
}
