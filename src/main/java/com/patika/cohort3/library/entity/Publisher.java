package com.patika.cohort3.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer establishmentYear;
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> books;

}
