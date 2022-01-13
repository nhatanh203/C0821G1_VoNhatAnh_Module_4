package com.codegym.casestudy_furama.service.customer;

import com.codegym.casestudy_furama.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> getAll();

    CustomerType findById(Integer id);

    void save(CustomerType customerType);

    List<CustomerType> findByName(String name);

    void remove(Integer id);
}
