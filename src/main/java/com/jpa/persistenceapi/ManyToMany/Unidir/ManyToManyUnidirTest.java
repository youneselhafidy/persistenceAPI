package com.jpa.persistenceapi.ManyToMany.Unidir;

import jakarta.persistence.*;
import java.util.Arrays;

public class ManyToManyUnidirTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Course course1 = new Course();
        course1.setTitle("Mathematics");
        Course course2 = new Course();
        course2.setTitle("Physics");

        em.persist(course1);
        em.persist(course2);

        StudentManyToManyUnidir student = new StudentManyToManyUnidir();
        student.setName("Charlie");
        student.setCourses(Arrays.asList(course1, course2));
        em.persist(student);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
