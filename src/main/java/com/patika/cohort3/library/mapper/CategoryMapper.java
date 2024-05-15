package com.patika.cohort3.library.mapper;

import com.patika.cohort3.library.dto.request.category.CategorySaveRequest;
import com.patika.cohort3.library.dto.request.category.CategoryUpdateRequest;
import com.patika.cohort3.library.dto.response.category.CategoryResponse;
import com.patika.cohort3.library.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );
    Category asEntity(CategorySaveRequest categorySaveRequest);
    Category asEntity(CategoryUpdateRequest categoryUpdateRequest);
    CategoryResponse asOutput(Category category);
    List<CategoryResponse> asOutput(List<Category> categories);
    void update(@MappingTarget Category entity, CategorySaveRequest request);
    void update(@MappingTarget Category entity, CategoryUpdateRequest request);
}
