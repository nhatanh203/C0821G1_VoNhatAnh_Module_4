package com.codegym.category_application.controller;

import com.codegym.category_application.model.Blog;
import com.codegym.category_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAll() {
        List<Blog> blogg = blogService.findAll();
        if (blogg.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogg, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Blog> findById(@PathVariable Integer id) {
        Blog blogg = blogService.findById(id);
        if (blogg == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogg, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Blog> save(@RequestBody Blog blogg) {
        if (blogg == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(blogg);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}