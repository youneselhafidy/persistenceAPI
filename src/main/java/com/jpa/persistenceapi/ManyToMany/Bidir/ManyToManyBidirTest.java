package com.jpa.persistenceapi.ManyToMany.Bidir;

import jakarta.persistence.*;
import java.util.Arrays;

public class ManyToManyBidirTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        StudentManyToManyBidir student1 = new StudentManyToManyBidir();
        student1.setName("Charlie");

        StudentManyToManyBidir student2 = new StudentManyToManyBidir();
        student2.setName("Diana");

        CourseBidir course1 = new CourseBidir();
        course1.setTitle("Computer Science");

        CourseBidir course2 = new CourseBidir();
        course2.setTitle("Mathematics");

        // Établir les relations bidirectionnelles
        student1.setCourses(Arrays.asList(course1, course2));
        student2.setCourses(Arrays.asList(course1));

        course1.setStudents(Arrays.asList(student1, student2));
        course2.setStudents(Arrays.asList(student1));

        em.persist(student1);
        em.persist(student2);
        em.persist(course1);
        em.persist(course2);

        em.getTransaction().commit();

        // Vérification
        StudentManyToManyBidir foundStudent = em.find(StudentManyToManyBidir.class, student1.getId());
        System.out.println("Étudiant : " + foundStudent.getName());
        for (CourseBidir c : foundStudent.getCourses()) {
            System.out.println(" - Cours : " + c.getTitle());
        }

        em.close();
        emf.close();
    }
}
