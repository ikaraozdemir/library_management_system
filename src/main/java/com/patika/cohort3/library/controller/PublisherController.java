package com.patika.cohort3.library.controller;


import com.patika.cohort3.library.dto.request.publisher.PublisherSaveRequest;
import com.patika.cohort3.library.dto.request.publisher.PublisherUpdateRequest;
import com.patika.cohort3.library.dto.response.publisher.PublisherResponse;
import com.patika.cohort3.library.entity.Publisher;
import com.patika.cohort3.library.mapper.PublisherMapper;
import com.patika.cohort3.library.result.Result;
import com.patika.cohort3.library.result.ResultData;
import com.patika.cohort3.library.service.abstracts.PublisherService;
import com.patika.cohort3.library.utilities.ResultHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<PublisherResponse>> findAll() {
        List<Publisher> publishers = publisherService.findAll();
        List<PublisherResponse> responses = PublisherMapper.INSTANCE.asOutput(publishers);
        return ResultHelper.success(responses);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id") Long id) {
        Publisher publisher = this.publisherService.getById(id);
        PublisherResponse publisherResponse =  PublisherMapper.INSTANCE.asOutput(publisher);
        return ResultHelper.success(publisherResponse);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@RequestBody PublisherSaveRequest request) {
        Publisher savePublisher = PublisherMapper.INSTANCE.asEntity(request);
        this.publisherService.save(savePublisher);
        PublisherResponse publisherResponse = PublisherMapper.INSTANCE.asOutput(savePublisher);
        return ResultHelper.created(publisherResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest request) {
        Publisher updatePublisher = PublisherMapper.INSTANCE.asEntity(request);
        this.publisherService.update(updatePublisher);
        PublisherResponse publisherResponse = PublisherMapper.INSTANCE.asOutput(updatePublisher);
        return ResultHelper.success(publisherResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete (@PathVariable("id") Long id) {
        this.publisherService.delete(id);
        return ResultHelper.ok();
    }

}
