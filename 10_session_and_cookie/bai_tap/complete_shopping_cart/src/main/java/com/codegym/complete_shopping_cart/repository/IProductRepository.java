package com.codegym.complete_shopping_cart.repository;

import com.codegym.complete_shopping_cart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long>{
}
