package com.codegym.demo_full_md4.repository;

import com.codegym.demo_full_md4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
}
