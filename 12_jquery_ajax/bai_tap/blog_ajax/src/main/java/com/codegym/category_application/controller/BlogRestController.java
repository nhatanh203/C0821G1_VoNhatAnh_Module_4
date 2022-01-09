package com.codegym.category_application.controller;

import com.codegym.category_application.model.Blog;
import com.codegym.category_application.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = "*")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> showList(@RequestParam(name = "title", required = false) String title,
                                               @RequestParam(name = "offset", required = false) Integer offset){
        List<Blog> blogList = blogService.searchByName(title,offset);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
