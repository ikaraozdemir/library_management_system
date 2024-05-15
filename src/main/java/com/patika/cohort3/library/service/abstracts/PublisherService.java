package com.patika.cohort3.library.service.abstracts;

import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.entity.Publisher;

import java.util.List;

public interface PublisherService {
    public Publisher save(Publisher publisher);
    public Publisher update(Publisher publisher);
    public boolean delete(Long id);
    public Publisher getById(Long id);
    public Publisher getByName(String name);
    public List<Publisher> findAll();

}
