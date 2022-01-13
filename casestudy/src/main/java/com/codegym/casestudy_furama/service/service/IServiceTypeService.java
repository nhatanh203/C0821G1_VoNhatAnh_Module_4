package com.codegym.casestudy_furama.service.service;

import com.codegym.casestudy_furama.model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> getAll();

    ServiceType findById(Integer id);

    void save(ServiceType serviceType);

    List<ServiceType> findByName(String name);

    void remove(Integer id);
}
