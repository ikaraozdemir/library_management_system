package com.patika.cohort3.library.service.abstracts;

import com.patika.cohort3.library.entity.Category;
import org.springframework.stereotype.Service;

public interface CategoryService {
    public Category save(Category category);
    public Category update(Category category);
    public boolean delete(Long id);
    public Category getById(Long id);
}
