package com.codegym.casestudy_furama.service.customer;

import com.codegym.casestudy_furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    Customer findById(Integer id);

    void save(Customer customer);

    List<Customer> findByName(String name);

    void remove(Integer id);

    Page<Customer> findAll(PageRequest of);
}
