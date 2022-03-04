package com.ajc.jpa.impl;

import com.ajc.jpa.dao.ArtistDao;
import com.ajc.jpa.model.Artist;
import com.ajc.jpa.model.PersonId;
import com.ajc.jpa.model.SacemRegistration;
import com.ajc.jpa.utils.JpaDaoManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ArtistDaoImpl implements ArtistDao {
    @Override
    public Artist findById(PersonId id) {
        EntityManager em = null;
        Artist artist=null;
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query=em.createQuery("from Artist where id = :first" );
            query.setParameter("first", id);
            artist= (Artist) query.getSingleResult();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(em!=null)em.close();
        }
        return artist;
    }

    @Override
    public List<Artist> findAll() {
        EntityManager em = null;
        List<Artist> artistList=new ArrayList<>();
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query=em.createQuery("from Artist ");
            artistList= query.getResultList();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(em!=null)em.close();
        }
        return artistList;
    }

    @Override
    public void add(Artist obj) {
        EntityManager em = null;
        EntityTransaction transaction=null;
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction=em.getTransaction();
            transaction.begin();
            em.persist(obj);
            transaction.commit();

        } catch(Exception e){
            System.out.println(e.getMessage());
            if (transaction!=null)transaction.rollback();
        }finally{
            if(em!=null)em.close();
        }
    }

    @Override
    public void update(Artist obj) {
        EntityManager em = null;
        EntityTransaction transaction=null;
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction=em.getTransaction();
            transaction.begin();
            em.merge(obj);
            transaction.commit();

        } catch(Exception e){
            System.out.println(e.getMessage());
            if (transaction!=null)transaction.rollback();
        }finally{
            if(em!=null)em.close();
        }
    }

    @Override
    public void remove(Artist obj) {
        EntityManager em = null;
        EntityTransaction transaction=null;
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction=em.getTransaction();
            transaction.begin();
            em.merge(obj);
            em.remove(obj);
            transaction.commit();

        } catch(Exception e){
            System.out.println(e.getMessage());
            if (transaction!=null)transaction.rollback();
        }finally{
            if(em!=null)em.close();
        }
    }

    @Override
    public void removeById(PersonId id) {
        EntityManager em = null;
        EntityTransaction transaction=null;
        try{

            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction=em.getTransaction();
            transaction.begin();
            Artist artist = em.merge( this.findById(id));
            em.remove(artist);
            transaction.commit();

        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            if (transaction!=null)transaction.rollback();
        }finally{
            if(em!=null)em.close();
        }
    }
}
