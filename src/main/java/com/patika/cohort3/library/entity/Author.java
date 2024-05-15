package com.patika.cohort3.library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String country;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private List<Book> books;
}
