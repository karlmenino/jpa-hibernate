package com.ajc.jpa;

import com.ajc.jpa.model.*;

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
        album.setArtist(artist);
        artist.setSacem(sacem);
        em.getTransaction().commit();



    }
}
//        SacemRegistration sacemRegistration=em.find(SacemRegistration.class,"far");
//        em.getTransaction().begin();
//        em.remove(sacemRegistration);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();