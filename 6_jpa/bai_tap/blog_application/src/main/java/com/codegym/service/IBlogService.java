package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> findAll();

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);
}
