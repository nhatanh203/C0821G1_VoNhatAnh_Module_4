package com.codegym.casestudy_furama.repository.customer;

import com.codegym.casestudy_furama.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findByName(String name);
}
