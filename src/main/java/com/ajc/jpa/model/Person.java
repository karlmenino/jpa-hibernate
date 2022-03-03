package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Person  {
    public Person() {
    }

    public Person(PersonId id, Address address) {
        this.id = id;
        this.address = address;
    }

    @EmbeddedId
    private  PersonId id;


    @Embedded
    private Address address;

}
