package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository iProductRepo;
    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepo.delete(id);
    }

    @Override
    public void editById(int id, String nameEdit, int priceEdit) {
        iProductRepo.editById(id,nameEdit,priceEdit);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }
}
