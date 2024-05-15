package com.patika.cohort3.library.mapper;

import com.patika.cohort3.library.dto.request.author.AuthorSaveRequest;
import com.patika.cohort3.library.dto.request.author.AuthorUpdateRequest;
import com.patika.cohort3.library.dto.response.author.AuthorResponse;
import com.patika.cohort3.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper( AuthorMapper.class );
    Author asEntity(AuthorSaveRequest authorSaveRequest);
    Author asEntity(AuthorUpdateRequest authorUpdateRequest);
    AuthorResponse asOutput(Author author);
    List<AuthorResponse> asOutput(List<Author> categories);

}
