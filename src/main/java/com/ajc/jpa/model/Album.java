package com.ajc.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Album {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private int releaseYear;
    @ManyToOne
    @JoinColumn(name = "firstname")
    @JoinColumn(name = "lastname")
    private Artist artist;

    @ManyToMany(mappedBy = "albums")
    private List<Playlist> plays;
}
