package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data

public class User extends Person {

    @Column
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Playlist> plays;


}
