package com.codegym.casestudy_furama.service.contract.impl;

import com.codegym.casestudy_furama.model.contract.ContractDetail;
import com.codegym.casestudy_furama.repository.contract.IContractDetailRepository;
import com.codegym.casestudy_furama.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepo;

    @Override
    public List<ContractDetail> getAll() {
        return iContractDetailRepo.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContractDetailRepo.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepo.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iContractDetailRepo.deleteById(id);
    }
}
