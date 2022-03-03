package com.ajc.jpa.model;



import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="artist")
public class Artist extends Person {

    @Column
    private String bandName;
    @Column
    private int size;

    @OneToMany(mappedBy="artist")
    private List<Album> albums;

    @OneToOne
    private SacemRegistration sacem;



}
