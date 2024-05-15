package com.patika.cohort3.library.mapper;

import com.patika.cohort3.library.dto.request.category.CategorySaveRequest;
import com.patika.cohort3.library.dto.request.category.CategoryUpdateRequest;
import com.patika.cohort3.library.dto.request.publisher.PublisherSaveRequest;
import com.patika.cohort3.library.dto.request.publisher.PublisherUpdateRequest;
import com.patika.cohort3.library.dto.response.category.CategoryResponse;
import com.patika.cohort3.library.dto.response.publisher.PublisherResponse;
import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper( PublisherMapper.class );
    Publisher asEntity(PublisherSaveRequest publisherSaveRequest);
    Publisher asEntity(PublisherUpdateRequest publisherUpdateRequest);
    PublisherResponse asOutput(Publisher publisher);
    List<PublisherResponse> asOutput(List<Publisher> publishers);
//    void update(@MappingTarget Category entity, CategorySaveRequest request);
//    void update(@MappingTarget Category entity, CategoryUpdateRequest request);

}
