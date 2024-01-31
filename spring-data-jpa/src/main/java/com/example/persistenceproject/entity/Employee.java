package com.example.persistenceproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private int level;

    public Employee() {}
    public Employee(String username, String firstname, String lastname, String email, int level) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.level = level;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
                + ", email=" + email + ", level=" + level + "]";
    }
}
