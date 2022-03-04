package com.ajc.jpa.dao;

import com.ajc.jpa.model.SacemRegistration;

import java.time.LocalDate;

public interface SacemDao extends Dao<SacemRegistration, String> {
    public SacemRegistration findByDate(LocalDate date);
}
