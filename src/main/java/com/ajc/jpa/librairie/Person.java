//package com.ajc.jpa.librairie;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//public class Person {
//    @Id
//    @Column(nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column
//    private String name;
//    @OneToOne()
//    private Book book;
//    @ManyToOne
//    private Library library;
//}
