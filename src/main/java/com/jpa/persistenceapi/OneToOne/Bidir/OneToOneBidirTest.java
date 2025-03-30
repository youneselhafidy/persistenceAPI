package com.jpa.persistenceapi.OneToOne.Bidir;

import jakarta.persistence.*;

public class OneToOneBidirTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        AddressBidir address = new AddressBidir();
        address.setStreet("456 Elm St");
        address.setCity("Los Angeles");

        EmployeeOneToOneBidir employee = new EmployeeOneToOneBidir();
        employee.setName("Jane Doe");

        // Établir la relation bidirectionnelle
        employee.setAddress(address);
        address.setEmployee(employee);

        em.persist(employee);
        em.persist(address);

        em.getTransaction().commit();

        // Vérification
        EmployeeOneToOneBidir foundEmployee = em.find(EmployeeOneToOneBidir.class, employee.getId());
        System.out.println("Employé : " + foundEmployee.getName() + " - Adresse : " + foundEmployee.getAddress().getStreet());
        Query query = em.createQuery("SELECT a FROM AddressBidir a WHERE a.employee.id = :id");
        // result
        query.setParameter("id", foundEmployee.getId());
        AddressBidir foundAddress = (AddressBidir) query.getSingleResult();
        System.out.println("Adresse : " + foundAddress.getStreet() + " - Employé : " + foundAddress.getEmployee().getName());

        em.close();
        emf.close();
    }
}
