package com.ajc.jpa.utils;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Getter
public class JpaDaoManager {
    private static JpaDaoManager instance=null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("disco");
    private JpaDaoManager() {}

    public static JpaDaoManager getInstance() {
        if (instance == null)instance = new JpaDaoManager();
        return instance;
    }
    public static void stop() {
        instance.emf.close();
    }
}
