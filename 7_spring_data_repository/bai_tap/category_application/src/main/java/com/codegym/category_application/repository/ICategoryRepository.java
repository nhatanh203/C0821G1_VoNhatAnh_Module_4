package com.codegym.category_application.repository;


import com.codegym.category_application.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iCateRepo")
public interface ICategoryRepository extends JpaRepository<Category,String> {
}
