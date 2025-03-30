package com.jpa.persistenceapi.OneToOne.Unidir;

import jakarta.persistence.*;

public class OneToOneUnidirTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("New York");
        em.persist(address);

        EmployeeOneToOneUnidir employee = new EmployeeOneToOneUnidir();
        employee.setName("John Doe");
        employee.setAddress(address);
        em.persist(employee);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

