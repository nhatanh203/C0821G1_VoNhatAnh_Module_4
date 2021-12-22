package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    static List<Product> listProdct = new ArrayList<>();

    static {
        listProdct.add(new Product(1, "socola", 12000));
        listProdct.add(new Product(2, "candy", 5000));
        listProdct.add(new Product(3, "cake", 30000));
        listProdct.add(new Product(4, "cream", 5000));
    }

    @Override
    public List<Product> findAll() {
        return listProdct;
    }

    @Override
    public void save(Product product) {
        listProdct.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < findAll().size(); i++) {
            if (id == findAll().get(i).getId()) {
                return findAll().get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        listProdct.remove(id);
    }

    @Override
    public void editById(int id, String nameEdit, int priceEdit) {
        for (int i = 0; i < findAll().size(); i++) {
            if (id == findAll().get(i).getId()) {
                findAll().get(i).setName(nameEdit);
                findAll().get(i).setPrice(priceEdit);
            }
        }
    }
}
