package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class SacemRegistration {
    @Id
    private String reference;
    @Column
    private LocalDate dateRegistration;

    public SacemRegistration(String reference, LocalDate dateRegistration) {
        this.reference = reference;
        this.dateRegistration = dateRegistration;
    }

    public SacemRegistration() {

    }
}
