package com.jpa.persistenceapi.OneToOne.Bidir;

import jakarta.persistence.*;

@Entity
public class AddressBidir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private EmployeeOneToOneBidir employee;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public EmployeeOneToOneBidir getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeOneToOneBidir employee) {
        this.employee = employee;
    }
}