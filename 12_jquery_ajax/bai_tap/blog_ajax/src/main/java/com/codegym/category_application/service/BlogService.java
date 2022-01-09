package com.codegym.category_application.service;


import com.codegym.category_application.model.Blog;
import com.codegym.category_application.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepo;

    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> searchByName(String name, Integer offset) {
        return blogRepo.searchByName("%" + name + "%",offset);
    }


}
