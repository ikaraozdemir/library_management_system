package com.patika.cohort3.library.service.concretes;

import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.entity.Publisher;
import com.patika.cohort3.library.exception.NotFoundException;
import com.patika.cohort3.library.exception.PublisherAlreadyExistsException;
import com.patika.cohort3.library.repository.PublisherRepository;
import com.patika.cohort3.library.service.abstracts.PublisherService;
import com.patika.cohort3.library.utilities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherServiceImp implements PublisherService {
    private final PublisherRepository publisherRepository;


    @Override
    public Publisher getById(Long id) {
        return this.publisherRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public Publisher getByName(String name) {
        return this.publisherRepository.findByName(name).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        Optional<Publisher> isPublisherExist = this.publisherRepository.findByName(publisher.getName());
        if (isPublisherExist.isPresent()) {
            throw new PublisherAlreadyExistsException("Bu yayınevi sistemde mevcut!");
        }
        return this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher update(Publisher publisher) {

        this.getById(publisher.getId());
        Optional<Publisher> isPublisherExist = this.publisherRepository.findByName(publisher.getName());
        if (isPublisherExist.isPresent()) {
            throw new PublisherAlreadyExistsException("Bu yayınevi sistemde mevcut!");
        }
        return this.publisherRepository.save(publisher);
    }

    @Override
    public boolean delete(Long id) {
        Publisher publisher = this.getById(id);
        this.publisherRepository.delete(publisher);
        return true;
    }

}
