package com.ajc.jpa.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Album {
    public Album() {
    }

    public Album(String title) {
        this.title = title;
    }

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
    @ToString.Exclude
    @ManyToMany(mappedBy = "albums",cascade = CascadeType.ALL)
    private List<Playlist> plays=new ArrayList<>();
}
