package com.codegym.complete_shopping_cart.service;

import com.codegym.complete_shopping_cart.model.Product;
import com.codegym.complete_shopping_cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findId(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
