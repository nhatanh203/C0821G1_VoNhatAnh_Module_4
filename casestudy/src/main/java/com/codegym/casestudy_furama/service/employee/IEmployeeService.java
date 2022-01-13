package com.codegym.casestudy_furama.service.employee;

import com.codegym.casestudy_furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    Employee findById(Integer id);

    void save(Employee employee);

    List<Employee> findByName(String name);

    void remove(Integer id);

    Page<Employee> findAll(PageRequest of);
}
