package com.codegym.casestudy_furama.repository.service;

import com.codegym.casestudy_furama.model.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services,Integer> {
}
