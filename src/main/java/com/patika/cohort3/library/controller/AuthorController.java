package com.patika.cohort3.library.controller;

import com.patika.cohort3.library.dto.request.author.AuthorSaveRequest;
import com.patika.cohort3.library.dto.request.author.AuthorUpdateRequest;
import com.patika.cohort3.library.dto.request.category.CategorySaveRequest;
import com.patika.cohort3.library.dto.request.category.CategoryUpdateRequest;
import com.patika.cohort3.library.dto.response.author.AuthorResponse;
import com.patika.cohort3.library.dto.response.category.CategoryResponse;
import com.patika.cohort3.library.dto.response.publisher.PublisherResponse;
import com.patika.cohort3.library.entity.Author;
import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.entity.Publisher;
import com.patika.cohort3.library.mapper.AuthorMapper;
import com.patika.cohort3.library.mapper.CategoryMapper;
import com.patika.cohort3.library.mapper.PublisherMapper;
import com.patika.cohort3.library.result.Result;
import com.patika.cohort3.library.result.ResultData;
import com.patika.cohort3.library.service.abstracts.AuthorService;
import com.patika.cohort3.library.utilities.ResultHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@RequestBody AuthorSaveRequest request) {
        Author saveAuthor = AuthorMapper.INSTANCE.asEntity(request);
        this.authorService.save(saveAuthor);
        AuthorResponse authorResponse = AuthorMapper.INSTANCE.asOutput(saveAuthor);
        return ResultHelper.created(authorResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest request) {
        Author updateAuthor = AuthorMapper.INSTANCE.asEntity(request);
        this.authorService.update(updateAuthor);
        AuthorResponse authorResponse = AuthorMapper.INSTANCE.asOutput(updateAuthor);
        return ResultHelper.success(authorResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<AuthorResponse>> findAll() {
        List<Author> authors = authorService.findAll();
        List<AuthorResponse> responses = AuthorMapper.INSTANCE.asOutput(authors);
        return ResultHelper.success(responses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable("id") Long id) {
        Author author = this.authorService.getById(id);
        AuthorResponse authorResponse =  AuthorMapper.INSTANCE.asOutput(author);
        return ResultHelper.success(authorResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete (@PathVariable("id") Long id) {
        this.authorService.delete(id);
        return ResultHelper.ok();
    }

}
