package com.codegym.casestudy_furama.service.contract;

import com.codegym.casestudy_furama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IContractService {

    List<Contract> getAll();

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> findByName(String name);

    void remove(Integer id);

    Page<Contract> findAll(PageRequest of);
}
