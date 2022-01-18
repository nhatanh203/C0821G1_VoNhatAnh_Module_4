package com.codegym.example_module.service;

import com.codegym.example_module.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> getAll();

    ProductType findById(Integer id);

    void save(ProductType productType);

    List<ProductType> findByName(String name);

    void remove(Integer id);
}
