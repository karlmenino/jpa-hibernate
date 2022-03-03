package com.ajc.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonId implements Serializable {

    private String firstName;
    private String lastName;
}
