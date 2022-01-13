package com.codegym.casestudy_furama.service.service.impl;

import com.codegym.casestudy_furama.model.service.Services;
import com.codegym.casestudy_furama.repository.service.IServiceRepository;
import com.codegym.casestudy_furama.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRep;

    @Override
    public List<Services> getAll() {
        return iServiceRep.findAll();
    }

    @Override
    public Services findById(Integer id) {
        return iServiceRep.findById(id).orElse(null);
    }

    @Override
    public void save(Services services) {
        iServiceRep.save(services);
    }

    @Override
    public List<Services> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iServiceRep.deleteById(id);
    }

    @Override
    public Page<Services> findAll(PageRequest of) {
        return iServiceRep.findAll(of);
    }
}
