package com.codegym.casestudy_furama.service.contract.impl;

import com.codegym.casestudy_furama.model.contract.Contract;
import com.codegym.casestudy_furama.repository.contract.IContractRepository;
import com.codegym.casestudy_furama.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository iContractRepo;

    @Override
    public List<Contract> getAll() {
        return iContractRepo.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        iContractRepo.save(contract);
    }

    @Override
    public List<Contract> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iContractRepo.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(PageRequest of) {
        return iContractRepo.findAll(of);
    }
}
