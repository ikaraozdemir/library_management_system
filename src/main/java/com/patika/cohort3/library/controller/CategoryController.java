package com.patika.cohort3.library.controller;

import com.patika.cohort3.library.dto.request.category.CategorySaveRequest;
import com.patika.cohort3.library.dto.request.category.CategoryUpdateRequest;
import com.patika.cohort3.library.dto.response.category.CategoryResponse;
import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.mapper.CategoryMapper;
import com.patika.cohort3.library.result.Result;
import com.patika.cohort3.library.result.ResultData;
import com.patika.cohort3.library.service.abstracts.CategoryService;
import com.patika.cohort3.library.utilities.Message;
import com.patika.cohort3.library.utilities.ResultHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@RequestBody CategorySaveRequest request) {
        Category saveCategory = CategoryMapper.INSTANCE.asEntity(request);
        this.categoryService.save(saveCategory);
        CategoryResponse categoryResponse = CategoryMapper.INSTANCE.asOutput(saveCategory);
        return ResultHelper.created(categoryResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest request) {
        Category updateCategory = CategoryMapper.INSTANCE.asEntity(request);
        this.categoryService.update(updateCategory);
        CategoryResponse categoryResponse = CategoryMapper.INSTANCE.asOutput(updateCategory);
        return ResultHelper.success(categoryResponse);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> get(@PathVariable("id") Long id) {
        Category category = this.categoryService.getById(id);
        CategoryResponse categoryResponse =  CategoryMapper.INSTANCE.asOutput(category);
        return ResultHelper.success(categoryResponse);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete (@PathVariable("id") Long id) {
        this.categoryService.delete(id);
        return ResultHelper.ok();
    }
}



