package com.codegym.demo_full_md4.repository;

import com.codegym.demo_full_md4.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTypeRepository extends JpaRepository<UserType,Integer> {
}
