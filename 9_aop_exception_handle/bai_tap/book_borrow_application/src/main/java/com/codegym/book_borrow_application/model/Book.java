package com.codegym.book_borrow_application.model;

import javax.persistence.*;

@Entity(name = "book_borrow")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "book_code")
    private int bookCode;
    @Column(name = "name")
    private String name;
    @Column(name = "remaining_amount")
    private int remaining_amount;

    public Book() {
    }

    public Book(int id, int bookCode, String name, int remaining_amount) {
        this.id = id;
        this.bookCode = bookCode;
        this.name = name;
        this.remaining_amount = remaining_amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemaining_amount(int remaining_amount) {
        this.remaining_amount = remaining_amount;
    }
}
