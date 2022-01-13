package com.codegym.casestudy_furama.repository.contract;

import com.codegym.casestudy_furama.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
}
