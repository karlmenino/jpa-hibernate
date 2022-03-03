package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Person  {

    @EmbeddedId
    private  PersonId id;


    @Embedded
    private Address address;

}
