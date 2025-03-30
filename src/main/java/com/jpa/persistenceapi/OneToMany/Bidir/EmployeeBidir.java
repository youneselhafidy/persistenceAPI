package com.jpa.persistenceapi.OneToMany.Bidir;

import jakarta.persistence.*;

@Entity
public class EmployeeBidir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentOneToManyBidir department;

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

    public DepartmentOneToManyBidir getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentOneToManyBidir department) {
        this.department = department;
    }
}