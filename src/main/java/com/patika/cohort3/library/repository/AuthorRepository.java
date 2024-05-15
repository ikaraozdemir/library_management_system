package com.patika.cohort3.library.repository;

import com.patika.cohort3.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findByNameAndBirthDateAndCountry(String name, LocalDate birthDate, String country);
    Optional<Author> findByName(String name);
}