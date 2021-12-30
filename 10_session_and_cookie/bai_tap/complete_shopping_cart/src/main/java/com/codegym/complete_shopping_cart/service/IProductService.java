package com.codegym.complete_shopping_cart.service;

import com.codegym.complete_shopping_cart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
