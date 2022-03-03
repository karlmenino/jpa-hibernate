package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class User extends Person {
    public User() {
    }
    public User(PersonId id, Address address) {
        super(id, address);
    }

    @Column
    private LocalDate birthDate;
    @OneToMany(mappedBy = "user")
    private List<Playlist> plays=new ArrayList<>();


}
