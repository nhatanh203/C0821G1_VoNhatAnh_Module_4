package com.codegym.registration_form.repository;

import com.codegym.registration_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "iUserRepo")
public interface IUserRepository extends JpaRepository<User,String> {
}
