package com.codegym.casestudy_furama.repository.contract;

import com.codegym.casestudy_furama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository  extends JpaRepository<ContractDetail,Integer> {
}
