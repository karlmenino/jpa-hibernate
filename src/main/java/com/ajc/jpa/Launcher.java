package com.ajc.jpa;

import com.ajc.jpa.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("disco");
        EntityManager em = emf.createEntityManager();
//
//        Artist artist = em.find(Artist.class,new PersonId("test","artiste"));
////
//        em.getTransaction().begin();
//        em.remove(artist);
//
//        em.getTransaction().commit();
//        System.out.println(em.find(Playlist.class,(long)2));
        Query q = em.createQuery("from User");
        List<User> users= q.getResultList();
        System.out.println(users);
        em.close();
        emf.close();


    }
    public static void init() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("disco");
        EntityManager em = emf.createEntityManager();
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        SacemRegistration sacem =new SacemRegistration("far",date);
        User user = new User(new PersonId("test","azerty"),new Address());
        Artist artist = new Artist(new PersonId("test", "artiste"), new Address(), "artiste", 1);
        Album album= new Album("album");
        Playlist playlist= new Playlist("playlist");

        em.getTransaction().begin();
        em.persist(sacem);
        em.persist(user);
        em.persist(artist);
        em.persist(album);
        em.persist(playlist);
        playlist.getAlbums().add(album);
        playlist.setUser(user);
//        album.setArtist(artist);
        artist.setSacem(sacem);
        em.close();
        emf.close();
    }
}
//        SacemRegistration sacemRegistration=em.find(SacemRegistration.class,"far");
//        em.getTransaction().begin();
//        em.remove(sacemRegistration);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();

