package com.ajc.jpa.impl;

import com.ajc.jpa.dao.SacemDao;
import com.ajc.jpa.model.SacemRegistration;
import com.ajc.jpa.utils.JpaDaoManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SacemDaoImpl implements SacemDao {
    @Override
    public SacemRegistration findById(String id) {
        EntityManager em = null;
        SacemRegistration sacem=null;
        try{
           em= JpaDaoManager.getInstance().getEmf().createEntityManager();
           Query query=em.createQuery("from SacemRegistration where reference= :id");
           query.setParameter("id", id);
           sacem= (SacemRegistration) query.getSingleResult();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(em!=null)em.close();
        }
        return sacem;
    }

    @Override
    public List<SacemRegistration> findAll() {
        EntityManager em = null;
        List<SacemRegistration> sacemList=new ArrayList<>();
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query=em.createQuery("from SacemRegistration");
            sacemList= query.getResultList();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(em!=null)em.close();
        }
        return sacemList;
    }

    @Override
    public void add(SacemRegistration obj) {
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
    public void update(SacemRegistration obj) {
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
    public void remove(SacemRegistration obj) {
        EntityManager em = null;
        EntityTransaction transaction=null;
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction=em.getTransaction();
            transaction.begin();
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
    public void removeById(String id) {
        EntityManager em = null;
        EntityTransaction transaction=null;
        try{
            SacemRegistration sacem = this.findById(id);
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            transaction=em.getTransaction();
            transaction.begin();
            em.persist(sacem);
            transaction.commit();

        } catch(Exception e){
            System.out.println(e.getMessage());
            if (transaction!=null)transaction.rollback();
        }finally{
            if(em!=null)em.close();
        }
    }

    @Override
    public SacemRegistration findByDate(LocalDate date) {
        EntityManager em = null;
        SacemRegistration sacem=null;
        try{
            em= JpaDaoManager.getInstance().getEmf().createEntityManager();
            Query query=em.createQuery("from SacemRegistration where dateRegistration= :id");
            query.setParameter("id", date);
            sacem= (SacemRegistration) query.getSingleResult();

        } catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            if(em!=null)em.close();
        }
        return sacem;
    }
}
