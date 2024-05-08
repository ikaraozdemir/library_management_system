package com.patika.cohort3.library.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> books;
}
