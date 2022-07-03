package com.duynguyen.furama.repository.user;

import com.duynguyen.furama.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);
}
