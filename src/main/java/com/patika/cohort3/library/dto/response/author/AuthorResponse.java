package com.patika.cohort3.library.dto.response.author;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorResponse {

    private Long id;
    private String name;
    private String country;
}
