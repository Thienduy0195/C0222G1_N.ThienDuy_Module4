package com.duynguyen.furama.repository.user;

import com.duynguyen.furama.model.user.User;
import com.duynguyen.furama.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUser(User appUser);

}
