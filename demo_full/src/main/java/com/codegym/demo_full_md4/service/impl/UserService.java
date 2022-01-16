package com.codegym.demo_full_md4.service.impl;

import com.codegym.demo_full_md4.model.User;
import com.codegym.demo_full_md4.repository.IUserRepository;
import com.codegym.demo_full_md4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepo;

    @Override
    public List<User> getAll() {
        return iUserRepo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return iUserRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        iUserRepo.save(user);
    }

    @Override
    public List<User> findByName(String name) {
        return iUserRepo.findByName(name);
    }

    @Override
    public void remove(Integer id) {
        iUserRepo.deleteById(id);
    }

    @Override
    public Page<User> findAll(PageRequest of) {
        return iUserRepo.findAll(of);
    }
}
