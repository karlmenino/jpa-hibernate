package com.ajc.jpa.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int streetNumber;
    private int postalCode;
    private String country;
    private String streetName;
}
