package com.codegym.demo_full_md4.service;

import com.codegym.demo_full_md4.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    List<User> getAll();

    User findById(Integer id);

    void save(User user);

    List<User> findByName(String name);

    void remove(Integer id);

    Page<User> findAll(PageRequest of);
}
