package com.jpa.persistenceapi.Heritage.Joined;

import jakarta.persistence.*;

@Entity
public class TeacherJoined extends PersonJoined {
    private String subject;

    // Getters et Setters

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}