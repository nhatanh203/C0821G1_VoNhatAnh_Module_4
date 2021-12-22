package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    public void save(Product product);
    public void delete(int id);
    public void editById(int id,String nameEdit,int priceEdit);
    public Product findById(int id);
}
