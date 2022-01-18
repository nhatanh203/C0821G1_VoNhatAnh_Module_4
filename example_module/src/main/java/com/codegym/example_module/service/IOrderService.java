package com.codegym.example_module.service;

import com.codegym.example_module.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();

    Order findById(Integer id);

    void save(Order order);

    List<Order> findByName(String name);

    void remove(Integer id);

    Page<Order> findAll(PageRequest of);
}
