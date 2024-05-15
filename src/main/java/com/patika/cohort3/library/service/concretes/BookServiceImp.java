package com.patika.cohort3.library.service.concretes;

import com.patika.cohort3.library.entity.Author;
import com.patika.cohort3.library.entity.Book;
import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.entity.Publisher;
import com.patika.cohort3.library.exception.BookAlreadyExistsException;
import com.patika.cohort3.library.exception.NotFoundException;
import com.patika.cohort3.library.exception.PublisherAlreadyExistsException;
import com.patika.cohort3.library.repository.AuthorRepository;
import com.patika.cohort3.library.repository.BookRepository;
import com.patika.cohort3.library.repository.CategoryRepository;
import com.patika.cohort3.library.repository.PublisherRepository;
import com.patika.cohort3.library.service.abstracts.BookService;
import com.patika.cohort3.library.utilities.Message;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Book save(Book book) {
        Optional<Book> isBookExist = bookRepository.findByNameAndAuthor(book.getName(), book.getAuthor());
        if (isBookExist.isPresent()) {
            throw new PublisherAlreadyExistsException("Bu kitap sistemde mevcut!");
        }

        Optional<Author> optionalAuthor = authorRepository.findByName(book.getAuthor().getName());
        Author author = optionalAuthor.orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Optional<Publisher> optionalPublisher = publisherRepository.findByName(book.getPublisher().getName());
        Publisher publisher = optionalPublisher.orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        List<Category> categories = new ArrayList<>();
        for (Category bookCategory : book.getCategories()) {
            Optional<Category> optionalCategory = categoryRepository.findByName(bookCategory.getName());
            Category category = optionalCategory.orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
            categories.add(category);
        }

        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(categories);

        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
//        System.out.println(book.getId());
        this.getById(book.getId());
        Optional<Book> isBookExist = this.bookRepository.findByNameAndAuthor(book.getName(),book.getAuthor());
//        if (isBookExist.isPresent()) {
//            throw new BookAlreadyExistsException("Bu kitap sistemde mevcut!");
//        }

        Optional<Author> optionalAuthor = authorRepository.findByName(book.getAuthor().getName());
        Author author = optionalAuthor.orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Optional<Publisher> optionalPublisher = publisherRepository.findByName(book.getPublisher().getName());
        Publisher publisher = optionalPublisher.orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        List<Category> categories = new ArrayList<>();
        for (Category bookCategory : book.getCategories()) {
            Optional<Category> optionalCategory = categoryRepository.findByName(bookCategory.getName());
            Category category = optionalCategory.orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
            categories.add(category);
        }

        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setCategories(categories);
        return this.bookRepository.save(book);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Book getById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }
}
