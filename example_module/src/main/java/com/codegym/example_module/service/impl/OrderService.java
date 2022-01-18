package com.codegym.example_module.service.impl;

import com.codegym.example_module.model.Order;
import com.codegym.example_module.repository.IOrderRepository;
import com.codegym.example_module.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository iOrderRepo;

    @Override
    public List<Order> getAll() {
        return iOrderRepo.findAll();
    }

    @Override
    public Order findById(Integer id) {
        return iOrderRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Order order) {
        iOrderRepo.save(order);
    }

    @Override
    public List<Order> findByName(String name) {
        return iOrderRepo.findByName(name);
    }

    @Override
    public void remove(Integer id) {
        iOrderRepo.deleteById(id);
    }

    @Override
    public Page<Order> findAll(PageRequest of) {
        return iOrderRepo.findAll(of);
    }
}
