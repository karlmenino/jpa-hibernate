package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Playlist {
    public Playlist() {
    }

    public Playlist(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate createdOn;
    @Column
    private String name;
    @ManyToOne()
    private User user;
    @ManyToMany
    private List<Album> albums=new ArrayList<>();


}
