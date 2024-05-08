package com.patika.cohort3.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany (mappedBy = "categories", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Book> books;

}
