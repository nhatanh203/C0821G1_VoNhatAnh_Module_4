package com.codegym.book_borrow_application.repository;

import com.codegym.book_borrow_application.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iBookRepo")
public interface IBookRepository extends JpaRepository<Book,Integer> {
}
