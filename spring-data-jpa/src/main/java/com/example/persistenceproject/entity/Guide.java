package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(exclude = {"students"})
@NamedEntityGraph( name = "Guide.students",attributeNodes = { @NamedAttributeNode("students") } )
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "staff_id",nullable = false,unique = true)
    private String staffId;
    private String name;
    private Integer salary;

    //inverse side
    @OneToMany(mappedBy = "guide",cascade = {CascadeType.PERSIST},fetch = FetchType.LAZY /* Default*/,orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student){
        this.students.add(student);
        student.setGuide(this);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
        student.setGuide(null);
    }

//    @Version
//    private Integer version;

    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }
}
