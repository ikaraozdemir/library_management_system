package com.patika.cohort3.library.service.concretes;

import com.patika.cohort3.library.entity.Category;
import com.patika.cohort3.library.exception.CategoryAlreadyExistsException;
import com.patika.cohort3.library.exception.NotFoundException;
import com.patika.cohort3.library.repository.CategoryRepository;
import com.patika.cohort3.library.service.abstracts.CategoryService;
import com.patika.cohort3.library.utilities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;


    public CategoryServiceImp(CategoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    public Category getById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(()-> new NotFoundException(Message.NOT_FOUND));
    }


    @Override
    public Category save(Category category) {
        Optional<Category> isCategoryExist = categoryRepository.findByName(category.getName());
        if (!isCategoryExist.isEmpty()) {
            throw new CategoryAlreadyExistsException("Bu kategori sistemde mevcut !");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {

        this.getById(category.getId());
        Optional<Category> isCategoryExist = categoryRepository.findByName(category.getName());
        if (isCategoryExist.isPresent()) {
            throw new CategoryAlreadyExistsException("Bu kategori sistemde mevcut ! !");
        }
        return this.categoryRepository.save(category);
    }

    @Override
    public boolean delete(Long id) {
        Category category = this.getById(id);
        this.categoryRepository.delete(category);
        return true;
    }

//    public void deleteById(Long id) {
//        Optional<Publisher> publisherFromDb = publisherRepository.findById(id);
//        if (publisherFromDb.isPresent()) {
//            publisherRepository.delete(publisherFromDb.get());
//        } else {
//            throw new RuntimeException(id + "id li Yayın Evi sistemde bulunamadı !!!");
//        }
//    }

//    public String deleteById(Long id) {
//        Optional<Category> categoryFromDb = categoryRepository.findById(id);
//        List<Book> booksInCategory = bookService.findByCategoryId(id);
//
//        if (!categoryFromDb.isPresent()) {
//            return id + " id li Kategori sistemde bulunamadı!!!";
//        } else if (!booksInCategory.isEmpty()) {
//            return id + " id li Kategoriye ait sistemde kayıtlı kitap mevcut! Silme işlemi yapılamadı.";
//        } else {
//            categoryRepository.delete(categoryFromDb.get());
//            return "Kategori silme işlemi başarılı";
//        }
//    }

//    public boolean delete(int id) {
//        Category category = this.get(id);
//        this.categoryRepo.delete(category);
//        return true;
//    }

}
