package com.jpa.persistenceapi.Heritage.SingleTable;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
public class TeacherSingleTable extends PersonSingleTable {
    private String subject;

    // Getters et Setters

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}