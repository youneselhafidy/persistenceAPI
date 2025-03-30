package com.jpa.persistenceapi.Heritage.SingleTable;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("STUDENT")
public class StudentSingleTable extends PersonSingleTable {
    private String course;

    // Getters et Setters

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}