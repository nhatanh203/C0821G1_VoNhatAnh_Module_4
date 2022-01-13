package com.codegym.casestudy_furama.service.contract;

import com.codegym.casestudy_furama.model.contract.AttachService;

import java.util.List;

public interface IAttachServiceService {
    List<AttachService> getAll();

    AttachService findById(Integer id);

    void save(AttachService attachService);

    List<AttachService> findByName(String name);

    void remove(Integer id);
}
