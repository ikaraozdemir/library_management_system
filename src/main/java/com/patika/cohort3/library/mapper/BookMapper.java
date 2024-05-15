package com.patika.cohort3.library.mapper;

import com.patika.cohort3.library.dto.request.book.BookSaveRequest;
import com.patika.cohort3.library.dto.response.book.BookResponse;
import com.patika.cohort3.library.entity.Book;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    Book asEntity(BookSaveRequest bookSaveRequest);
    BookResponse asOutput(Book book);


}
