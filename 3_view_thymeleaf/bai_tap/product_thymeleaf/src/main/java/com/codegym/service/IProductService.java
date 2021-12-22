package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    public void save(Product product);
    public void delete(int id);
    public void editById(int id,String nameEdit,int priceEdit);
    public Product findById(int id);
}
