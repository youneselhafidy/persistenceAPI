package com.jpa.persistenceapi.Heritage;

import com.jpa.persistenceapi.Heritage.Joined.StudentJoined;
import com.jpa.persistenceapi.Heritage.Joined.TeacherJoined;
import com.jpa.persistenceapi.Heritage.SingleTable.StudentSingleTable;
import com.jpa.persistenceapi.Heritage.SingleTable.TeacherSingleTable;
import com.jpa.persistenceapi.Heritage.TablePerClass.StudentTablePerClass;
import com.jpa.persistenceapi.Heritage.TablePerClass.TeacherTablePerClass;
import jakarta.persistence.*;

import java.util.List;

public class InheritanceTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Test pour SINGLE_TABLE
        StudentSingleTable student1 = new StudentSingleTable();
        student1.setName("Alice");
        student1.setCourse("Math");

        TeacherSingleTable teacher1 = new TeacherSingleTable();
        teacher1.setName("Mr. Smith");
        teacher1.setSubject("Physics");

        em.persist(student1);
        em.persist(teacher1);

        // Test pour JOINED
        StudentJoined student2 = new StudentJoined();
        student2.setName("Bob");
        student2.setCourse("History");

        TeacherJoined teacher2 = new TeacherJoined();
        teacher2.setName("Mrs. Johnson");
        teacher2.setSubject("Biology");

        em.persist(student2);
        em.persist(teacher2);

        // Test pour TABLE_PER_CLASS
        StudentTablePerClass student3 = new StudentTablePerClass();
        student3.setName("Charlie");
        student3.setCourse("Computer Science");

        TeacherTablePerClass teacher3 = new TeacherTablePerClass();
        teacher3.setName("Dr. Brown");
        teacher3.setSubject("Chemistry");

        em.persist(student3);
        em.persist(teacher3);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
