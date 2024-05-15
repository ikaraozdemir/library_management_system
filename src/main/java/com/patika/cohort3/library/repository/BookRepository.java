package com.patika.cohort3.library.repository;

import com.patika.cohort3.library.entity.Author;
import com.patika.cohort3.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByNameAndAuthor(String name, Author author);
}