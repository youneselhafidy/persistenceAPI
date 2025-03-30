package com.jpa.persistenceapi.OneToOne.Bidir;

import jakarta.persistence.*;

@Entity
public class EmployeeOneToOneBidir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "employee")
    private AddressBidir address;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressBidir getAddress() {
        return address;
    }

    public void setAddress(AddressBidir address) {
        this.address = address;
    }
}