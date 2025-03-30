package com.jpa.persistenceapi.Heritage.TablePerClass;

import jakarta.persistence.*;

@Entity
public class StudentTablePerClass extends PersonTablePerClass {
    private String course;

    // Getters et Setters

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
