package com.example.persistenceproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter @Getter @NoArgsConstructor @ToString
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passportNumber;
    private String countryCode;

    //inverse-end
    @OneToOne(mappedBy = "passport",fetch = FetchType.EAGER /*Default*/)
    private Customer customer;

    public void addCustomer(Customer customer){
        this.customer = customer;
        customer.setPassport(this);
    }

    public void removeCustomer(Customer customer){
        this.customer = null;
        customer.setPassport(null);
    }

    public Passport(String passportNumber, String countryCode) {
        this.passportNumber = passportNumber;
        this.countryCode = countryCode;
    }
}
