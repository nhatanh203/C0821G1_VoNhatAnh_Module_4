package com.codegym.casestudy_furama.service.service;

import com.codegym.casestudy_furama.model.service.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IServiceService {
    List<Services> getAll();

    Services findById(Integer id);

    void save(Services services);

    List<Services> findByName(String name);

    void remove(Integer id);

    Page<Services> findAll(PageRequest of);
}
