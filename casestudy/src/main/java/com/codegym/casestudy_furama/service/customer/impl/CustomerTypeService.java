package com.codegym.casestudy_furama.service.customer.impl;

import com.codegym.casestudy_furama.model.customer.CustomerType;
import com.codegym.casestudy_furama.repository.customer.ICustomerRepository;
import com.codegym.casestudy_furama.repository.customer.ICustomerTypeRepository;
import com.codegym.casestudy_furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    ICustomerTypeRepository iCustomerTypeRepo;

    @Override
    public List<CustomerType> getAll() {
        return iCustomerTypeRepo.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return iCustomerTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        iCustomerTypeRepo.save(customerType);
    }

    @Override
    public List<CustomerType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iCustomerTypeRepo.deleteById(id);
    }
}
