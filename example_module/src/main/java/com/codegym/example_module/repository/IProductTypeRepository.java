package com.codegym.example_module.repository;

import com.codegym.example_module.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository  extends JpaRepository<ProductType,Integer> {
}
