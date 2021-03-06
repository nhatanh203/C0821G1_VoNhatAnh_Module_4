package com.codegym.category_application.service;



import com.codegym.category_application.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category cate);

    void remove(int id);

    Page<Category> findAll(Pageable of);
}
