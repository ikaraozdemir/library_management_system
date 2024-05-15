package com.patika.cohort3.library.service.abstracts;

import com.patika.cohort3.library.entity.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {
    public Author save(Author author);
    public Author update(Author author);
    public boolean delete(Long id);
    public Author getById(Long id);
    public List<Author> findAll();
    public Author getByName(String name);
}
