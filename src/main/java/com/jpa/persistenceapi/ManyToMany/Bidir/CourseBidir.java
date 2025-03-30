package com.jpa.persistenceapi.ManyToMany.Bidir;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CourseBidir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "student_course_bidir",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentManyToManyBidir> students;

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StudentManyToManyBidir> getStudents() {
        return students;
    }

    public void setStudents(List<StudentManyToManyBidir> students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}