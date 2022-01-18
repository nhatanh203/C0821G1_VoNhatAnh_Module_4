package com.codegym.example_module.service.impl;

import com.codegym.example_module.model.Product;
import com.codegym.example_module.repository.IProductRepository;
import com.codegym.example_module.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProducRepo;

    @Override
    public List<Product> getAll() {
        return iProducRepo.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return iProducRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        iProducRepo.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProducRepo.findByName(name);
    }

    @Override
    public void remove(Integer id) {
        iProducRepo.deleteById(id);
    }

    @Override
    public Page<Product> findAll(PageRequest of) {
        return iProducRepo.findAll(of);
    }
}
