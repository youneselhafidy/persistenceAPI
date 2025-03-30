package com.jpa.persistenceapi.ManyToMany.Bidir;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class StudentManyToManyBidir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "students")
    private List<CourseBidir> courses;

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

    public List<CourseBidir> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseBidir> courses) {
        this.courses = courses;
    }
}