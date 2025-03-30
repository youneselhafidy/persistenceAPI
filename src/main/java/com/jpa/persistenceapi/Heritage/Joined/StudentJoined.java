package com.jpa.persistenceapi.Heritage.Joined;

import jakarta.persistence.*;

@Entity
public class StudentJoined extends PersonJoined {
    private String course;

    // Getters et Setters

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}