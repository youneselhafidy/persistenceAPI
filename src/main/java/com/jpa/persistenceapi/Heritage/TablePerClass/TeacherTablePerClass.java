package com.jpa.persistenceapi.Heritage.TablePerClass;

import jakarta.persistence.*;

@Entity
public class TeacherTablePerClass extends PersonTablePerClass {
    private String subject;

    // Getters et Setters

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
