package com.example.persistenceproject.client;

import com.example.persistenceproject.entity.Student;
import com.example.persistenceproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentClient implements ApplicationRunner {

    private @Autowired StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Student student = new Student("Ram Sah","2024AN50123");
        studentRepository.save(student);
    }
}
