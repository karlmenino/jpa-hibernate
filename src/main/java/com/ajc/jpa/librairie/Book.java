//package com.ajc.jpa.librairie;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
////@Entity
//public class Book {
//    @Id
//    @Column(nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column
//    private String name;
//    @ManyToMany
//    private List<Library> libraries;
//    @OneToOne(mappedBy = "book")
//    private Person person;
//}
