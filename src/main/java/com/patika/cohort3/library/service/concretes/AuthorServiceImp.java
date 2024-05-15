package com.patika.cohort3.library.service.concretes;

import com.patika.cohort3.library.entity.Author;

import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.exception.AuthorAlreadyExistsException;

import com.patika.cohort3.library.exception.CategoryAlreadyExistsException;
import com.patika.cohort3.library.exception.NotFoundException;
import com.patika.cohort3.library.repository.AuthorRepository;
import com.patika.cohort3.library.service.abstracts.AuthorService;
import com.patika.cohort3.library.utilities.Message;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authorRepository;


    @Override
    public Author save(Author author) {
        System.out.println(author.getName());
        System.out.println(author.getBirthDate());
        System.out.println(author.getCountry());
        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(author.getName(), author.getBirthDate(), author.getCountry());
        if (!isAuthorExist.isEmpty()) {
            throw new AuthorAlreadyExistsException("Bu yazar sistemde mevcut !");
        }
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        this.getById(author.getId());
        Optional<Author> isAuthorExist = authorRepository.findByNameAndBirthDateAndCountry(author.getName(), author.getBirthDate(), author.getCountry());
        if (!isAuthorExist.isEmpty()) {
            throw new AuthorAlreadyExistsException("Bu yazar sistemde mevcut !");
        }
        return this.authorRepository.save(author);
    }

    @Override
    public boolean delete(Long id) {
        Author author = this.getById(id);
        this.authorRepository.delete(author);
        return true;
    }

    @Override
    public Author getById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    public Author getByName(String name) {
        return this.authorRepository.findByName(name).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }


    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

}
