package com.codegym.category_application.repository;

import com.codegym.category_application.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IBlogRepository  extends JpaRepository<Blog, Integer> {

    @Query(value ="SELECT * FROM blog WHERE blog.title like concat('%', ?1, '%') LIMIT ?2 , 2;", nativeQuery=true)
    List<Blog> searchByName(String title, int offset);
}
