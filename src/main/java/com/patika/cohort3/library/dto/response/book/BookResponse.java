package com.patika.cohort3.library.dto.response.book;

import com.patika.cohort3.library.dto.request.author.AuthorForBookRequest;
import com.patika.cohort3.library.dto.request.category.CategoryForBookRequest;
import com.patika.cohort3.library.dto.request.publisher.PublisherForBookRequest;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class BookResponse {
    private String name;
    private LocalDate publicationDate;
    private Integer stock;
    private AuthorForBookRequest author;
    private PublisherForBookRequest publisher;
    private Set<CategoryForBookRequest> categories;
}
