package com.codegym.casestudy_furama.repository.employee;

import com.codegym.casestudy_furama.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
