package com.patika.cohort3.library.dto.request.author;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorUpdateRequest {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String country;
}
