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

    //Owner side
    @ManyToOne(cascade = {CascadeType.PERSIST},fetch = FetchType.EAGER /* Default fetch type for manytoone*/)
    @JoinColumn(name = "guide_id")
    private Guide guide;

    public Student(String name, String enrollmentId){
        this.name = name;
        this.enrollmentId = enrollmentId;
    }

    public Student(String name, String enrollmentId, Guide guide) {
        this.name = name;
        this.enrollmentId = enrollmentId;
        this.guide = guide;
    }
}
