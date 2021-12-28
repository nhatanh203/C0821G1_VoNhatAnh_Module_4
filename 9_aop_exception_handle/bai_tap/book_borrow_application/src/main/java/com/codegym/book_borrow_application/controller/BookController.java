package com.codegym.book_borrow_application.controller;

import com.codegym.book_borrow_application.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    public String showListBook(Model model) {
        model.addAttribute("books", this.bookService.findAll());
        return "index";
    }
}
