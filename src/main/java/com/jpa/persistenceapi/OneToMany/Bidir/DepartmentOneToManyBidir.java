package com.jpa.persistenceapi.OneToMany.Bidir;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DepartmentOneToManyBidir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmployeeBidir> employees;

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

    public List<EmployeeBidir> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeBidir> employees) {
        this.employees = employees;
    }
}
