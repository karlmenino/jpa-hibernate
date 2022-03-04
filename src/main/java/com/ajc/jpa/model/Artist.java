package com.ajc.jpa.model;



import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="artist")
public class Artist extends Person {
    public Artist() {
    }

    public Artist(PersonId id, Address address, String bandName, int size) {
        super(id, address);
        this.bandName = bandName;
        this.size = size;
    }

    @Column
    private String bandName;
    @Column
    private int size;

    @OneToMany(mappedBy="artist")
    private List<Album> albums=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private SacemRegistration sacem;



}
