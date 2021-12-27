package com.codegym.registration_form.service;

import com.codegym.registration_form.dto.UserDTO;
import com.codegym.registration_form.model.User;
import com.codegym.registration_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    @Qualifier("iUserRepo")
    IUserRepository iUserRepo;

    @Override
    public List<User> findAll() {
        return iUserRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return iUserRepo.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public void save(User user) {
        iUserRepo.save(user);
    }

    @Override
    public void save(UserDTO userDto) {
        User user = new User(userDto.getId(),userDto.getFirstName(),userDto.getLastName(),userDto.getPhoneNumber(),userDto.getAge(),userDto.getEmail());
        iUserRepo.save(user);
    }
}
