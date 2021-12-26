package com.codegym.category_application.service;


import com.codegym.category_application.model.Category;
import com.codegym.category_application.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService implements ICategoryService{
    @Autowired
    @Qualifier("iCateRepo")
    ICategoryRepository iCateRepo;


    @Override
    public List<Category> findAll() {
        return iCateRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return iCateRepo.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public void save(Category cate) {
        iCateRepo.save(cate);
    }

    @Override
    public void remove(int id) {
        iCateRepo.deleteById(String.valueOf(id));
    }
}
