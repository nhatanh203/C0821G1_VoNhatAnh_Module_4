package com.codegym.example_module.service.impl;

import com.codegym.example_module.model.ProductType;
import com.codegym.example_module.repository.IProductTypeRepository;
import com.codegym.example_module.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    IProductTypeRepository iProductTypeRepo;

    @Override
    public List<ProductType> getAll() {
        return iProductTypeRepo.findAll();
    }

    @Override
    public ProductType findById(Integer id) {
        return iProductTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(ProductType productType) {
        iProductTypeRepo.save(productType);
    }

    @Override
    public List<ProductType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iProductTypeRepo.deleteById(id);
    }
}
