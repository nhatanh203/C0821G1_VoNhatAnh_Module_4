package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Blog;
import com.codegym.blog_application.model.Category;
import com.codegym.blog_application.repository.ICategoryRepository;
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
    public Category findById(String id) {
        return iCateRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Category cate) {
        iCateRepo.save(cate);
    }

    @Override
    public void remove(String id) {
        iCateRepo.deleteById(id);
    }
}
