package com.codegym.casestudy.repository.user;


import com.codegym.casestudy.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String userName);
}
