package com.codegym.casestudy_furama.service.contract.impl;

import com.codegym.casestudy_furama.model.contract.AttachService;
import com.codegym.casestudy_furama.repository.contract.IAttachServiceRepository;
import com.codegym.casestudy_furama.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService{

    @Autowired
    private IAttachServiceRepository iAttachServiceRepo;

    @Override
    public List<AttachService> getAll() {
        return iAttachServiceRepo.findAll();
    }

    @Override
    public AttachService findById(Integer id) {
        return iAttachServiceRepo.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService attachService) {
        iAttachServiceRepo.save(attachService);
    }

    @Override
    public List<AttachService> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iAttachServiceRepo.deleteById(id);
    }
}
