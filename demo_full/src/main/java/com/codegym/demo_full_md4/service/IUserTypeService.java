package com.codegym.demo_full_md4.service;

import com.codegym.demo_full_md4.model.UserType;

import java.util.List;

public interface IUserTypeService {
    List<UserType> getAll();

    UserType findById(Integer id);

    void save(UserType userType);

    List<UserType> findByName(String name);

    void remove(Integer id);
}
