//package com.ajc.jpa.librairie;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Data
//@Entity
//public class Library {
//    @Id
//    @Column( nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column
//    private String name;
//    @OneToMany(mappedBy = "library")
//    private List<Person> persons;
//    @ManyToMany(mappedBy = "libraries" )
//    private List<Book> books;
//}
