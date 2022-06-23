package com.codegym.validate_form.repository;

import com.codegym.validate_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
}
