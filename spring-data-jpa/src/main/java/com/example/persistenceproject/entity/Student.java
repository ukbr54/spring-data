package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Setter @Getter @NoArgsConstructor
@ToString
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "enrollment_id",nullable = false,unique = true)
    private String enrollmentId;

    public Student(String name, String enrollmentId){
        this.name = name;
        this.enrollmentId = enrollmentId;
    }

}
