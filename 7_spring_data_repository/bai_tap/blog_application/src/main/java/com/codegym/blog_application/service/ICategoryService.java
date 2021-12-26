package com.codegym.blog_application.service;

import com.codegym.blog_application.model.Category;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();

    Category findById(String id);

    void save(Category cate);

    void remove(String id);
}
