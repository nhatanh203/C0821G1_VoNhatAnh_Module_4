package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> listProduct = BaseRepository.entityManager.createQuery
                ("select s from product s", Product.class).getResultList();
        return listProduct;
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTrans = BaseRepository.entityManager.getTransaction();
        entityTrans.begin();
        BaseRepository.entityManager.persist(product);
        entityTrans.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < findAll().size(); i++) {
            if (id == findAll().get(i).getId()) {
                findAll().remove(i);
            }
        }
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
