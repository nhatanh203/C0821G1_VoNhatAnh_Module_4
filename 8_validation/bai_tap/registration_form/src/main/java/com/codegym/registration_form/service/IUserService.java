package com.codegym.registration_form.service;

import com.codegym.registration_form.dto.UserDTO;
import com.codegym.registration_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void save(UserDTO userDto);
}
