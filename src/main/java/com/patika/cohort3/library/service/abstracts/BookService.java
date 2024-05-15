package com.patika.cohort3.library.service.abstracts;

import com.patika.cohort3.library.entity.Book;
import com.patika.cohort3.library.entity.Publisher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public Book save(Book book);
    public Book update(Book book);
    public boolean delete(Long id);
    public Book getById(Long id);
    public List<Book> findAll();
}
