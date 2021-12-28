package com.codegym.book_borrow_application.service;

import com.codegym.book_borrow_application.model.Book;
import com.codegym.book_borrow_application.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    @Qualifier("iBookRepo")
    IBookRepository ibookRepo;

    @Override
    public List<Book> findAll() {
        return ibookRepo.findAll();
    }

    @Override
    public Book findById(int id) {
        return ibookRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        ibookRepo.save(book);
    }
}
