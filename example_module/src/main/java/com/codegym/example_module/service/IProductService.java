package com.codegym.example_module.service;

import com.codegym.example_module.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product findById(Integer id);

    void save(Product product);

    List<Product> findByName(String name);

    void remove(Integer id);

    Page<Product> findAll(PageRequest of);
}
