package com.codegym.casestudy_furama.service.employee.impl;

import com.codegym.casestudy_furama.model.employee.Employee;
import com.codegym.casestudy_furama.repository.employee.IEmployeeRepository;
import com.codegym.casestudy_furama.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepo;

    @Override
    public List<Employee> getAll() {
        return iEmployeeRepo.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepo.save(employee);
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iEmployeeRepo.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(PageRequest of) {
        return iEmployeeRepo.findAll(of);
    }
}
