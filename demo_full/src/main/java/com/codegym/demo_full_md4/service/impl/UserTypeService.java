package com.codegym.demo_full_md4.service.impl;

import com.codegym.demo_full_md4.model.UserType;
import com.codegym.demo_full_md4.repository.IUserTypeRepository;
import com.codegym.demo_full_md4.service.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService implements IUserTypeService {
    @Autowired
    IUserTypeRepository iUserTypeRepo;

    @Override
    public List<UserType> getAll() {
        return iUserTypeRepo.findAll();
    }

    @Override
    public UserType findById(Integer id) {
        return iUserTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(UserType userType) {
        iUserTypeRepo.save(userType);
    }

    @Override
    public List<UserType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iUserTypeRepo.deleteById(id);
    }
}
