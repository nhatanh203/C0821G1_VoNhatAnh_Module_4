package com.codegym.casestudy_furama.service.service.impl;

import com.codegym.casestudy_furama.model.service.ServiceType;
import com.codegym.casestudy_furama.repository.service.IServiceTypeRepository;
import com.codegym.casestudy_furama.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository iServiceTypeRepo;

    @Override
    public List<ServiceType> getAll() {
        return iServiceTypeRepo.findAll();
    }

    @Override
    public ServiceType findById(Integer id) {
        return iServiceTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        iServiceTypeRepo.save(serviceType);
    }

    @Override
    public List<ServiceType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iServiceTypeRepo.deleteById(id);
    }
}
