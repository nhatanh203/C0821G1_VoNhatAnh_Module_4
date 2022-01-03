package com.codegym.category_application.controller;

import com.codegym.category_application.model.Category;
import com.codegym.category_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService cateService;

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList =cateService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        Category  category = cateService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Category> saveBlog(@RequestBody Category category) {
        if (category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cateService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
