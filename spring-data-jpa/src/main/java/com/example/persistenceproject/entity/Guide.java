package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;

@Entity
@Getter @Setter @NoArgsConstructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "staff_id",nullable = false,unique = true)
    private String staffId;
    private String name;
    private String salary;
    @Version
    private Integer version;

    public Guide(String staffId, String name, String salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }
}
