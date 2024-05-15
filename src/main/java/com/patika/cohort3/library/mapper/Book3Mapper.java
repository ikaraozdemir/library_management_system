package com.patika.cohort3.library.mapper;

import com.patika.cohort3.library.dto.request.book.BookSaveRequest;
import com.patika.cohort3.library.dto.request.book.BookUpdateRequest;
import com.patika.cohort3.library.dto.response.book.BookResponse;
import com.patika.cohort3.library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Book3Mapper {
    Book3Mapper INSTANCE = Mappers.getMapper(Book3Mapper.class);
    Book asEntity(BookSaveRequest bookSaveRequest);
    BookResponse asOutput(Book book);
    Book asEntity(BookUpdateRequest bookUpdateRequest);

}
