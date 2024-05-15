package com.patika.cohort3.library.dto.request.publisher;

import lombok.Data;

@Data
public class PublisherSaveRequest {
    private String name;
    private Integer establishmentYear;
    private String address;
}
