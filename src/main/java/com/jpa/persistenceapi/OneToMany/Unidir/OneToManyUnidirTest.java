package com.jpa.persistenceapi.OneToMany.Unidir;

import jakarta.persistence.*;
import java.util.Arrays;

public class OneToManyUnidirTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Employee employee1 = new Employee();
        employee1.setName("Alice");
        Employee employee2 = new Employee();
        employee2.setName("Bob");

        em.persist(employee1);
        em.persist(employee2);

        DepartmentOneToManyUnidir department = new DepartmentOneToManyUnidir();
        department.setName("IT Department");
        department.setEmployees(Arrays.asList(employee1, employee2));
        em.persist(department);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

