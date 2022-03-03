package com.ajc.jpa;

import com.ajc.jpa.model.SacemRegistration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Launcher {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("disco");
        EntityManager em = emf.createEntityManager();
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        SacemRegistration sacem =new SacemRegistration("far",date);
        em.getTransaction().begin();
        em.persist(sacem);
        em.getTransaction().commit();

        SacemRegistration sacemRegistration=em.find(SacemRegistration.class,"far");
        em.getTransaction().begin();
        em.remove(sacemRegistration);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
