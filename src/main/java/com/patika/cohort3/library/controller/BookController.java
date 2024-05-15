package com.patika.cohort3.library.controller;

import com.patika.cohort3.library.dto.request.book.BookSaveRequest;
import com.patika.cohort3.library.dto.request.book.BookUpdateRequest;
import com.patika.cohort3.library.dto.response.book.BookResponse;
import com.patika.cohort3.library.entity.Author;
import com.patika.cohort3.library.entity.Book;
import com.patika.cohort3.library.entity.Publisher;
import com.patika.cohort3.library.mapper.Book3Mapper;
import com.patika.cohort3.library.result.ResultData;
import com.patika.cohort3.library.service.abstracts.AuthorService;
import com.patika.cohort3.library.service.abstracts.BookService;
import com.patika.cohort3.library.service.abstracts.PublisherService;
import com.patika.cohort3.library.utilities.ResultHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@RequestBody BookSaveRequest request) {
        Book saveBook = Book3Mapper.INSTANCE.asEntity(request);

        Author author = this.authorService.getByName(request.getAuthor().getName());
        saveBook.setAuthor(author);

        Publisher publisher = this.publisherService.getByName(request.getPublisher().getName());
        saveBook.setPublisher(publisher);

        this.bookService.save(saveBook);
        BookResponse bookResponse =Book3Mapper.INSTANCE.asOutput(saveBook);
        return ResultHelper.created(bookResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest request) {
        Book updateBook = Book3Mapper.INSTANCE.asEntity(request);
        Author author = this.authorService.getByName(request.getAuthor().getName());
        updateBook.setAuthor(author);

        Publisher publisher = this.publisherService.getByName(request.getPublisher().getName());
        updateBook.setPublisher(publisher);
        System.out.println(request.getPublisher().getName());

        this.bookService.update(updateBook);
        BookResponse bookResponse = Book3Mapper.INSTANCE.asOutput(updateBook);
        return ResultHelper.success(bookResponse);
    }

}
