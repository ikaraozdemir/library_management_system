package com.patika.cohort3.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate publicationDate;
    private Integer stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id")
    private Publisher publisher;

    @OneToMany (mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BookBorrowing> bookBorrowingList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "book_catogories" , joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;


}
