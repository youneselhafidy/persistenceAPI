package com.jpa.persistenceapi.OneToMany.Bidir;

import jakarta.persistence.*;
import java.util.Arrays;

public class OneToManyBidirTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        DepartmentOneToManyBidir department = new DepartmentOneToManyBidir();
        department.setName("HR Department");

        EmployeeBidir emp1 = new EmployeeBidir();
        emp1.setName("Alice");
        emp1.setDepartment(department);

        EmployeeBidir emp2 = new EmployeeBidir();
        emp2.setName("Bob");
        emp2.setDepartment(department);

        department.setEmployees(Arrays.asList(emp1, emp2));

        em.persist(department);
        em.persist(emp1);
        em.persist(emp2);

        em.getTransaction().commit();

        // Vérification
        DepartmentOneToManyBidir foundDept = em.find(DepartmentOneToManyBidir.class, department.getId());
        System.out.println("Département : " + foundDept.getName());
        for (EmployeeBidir e : foundDept.getEmployees()) {
            System.out.println(" - Employé : " + e.getName());
        }

        em.close();
        emf.close();
    }
}
