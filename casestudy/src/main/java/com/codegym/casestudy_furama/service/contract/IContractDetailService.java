package com.codegym.casestudy_furama.service.contract;

import com.codegym.casestudy_furama.model.contract.ContractDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> getAll();

    ContractDetail findById(Integer id);

    void save(ContractDetail contractDetail);

    List<ContractDetail> findByName(String name);

    void remove(Integer id);
}
