package com.codegym.book_borrow_application.service;

import com.codegym.book_borrow_application.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(int id);

    void save(Book book);

//    void save(UserDTO userDto);
}
