package com.codegym.casestudy_furama.service.customer.impl;

import com.codegym.casestudy_furama.model.customer.Customer;
import com.codegym.casestudy_furama.repository.customer.ICustomerRepository;
import com.codegym.casestudy_furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepo;

    @Override
    public List<Customer> getAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Customer findById(Integer id) {
         return iCustomerRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepo.save(customer);
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepo.findByName(name);
    }

    @Override
    public void remove(Integer id) {
        iCustomerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(PageRequest of) {
        return iCustomerRepo.findAll(of);
    }
}
