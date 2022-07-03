package com.codegym.casestudy.repository.user;


import com.codegym.casestudy.model.user.AppUser;
import com.codegym.casestudy.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository  extends JpaRepository<UserRole, Integer> {
    List<UserRole> findByUser(AppUser appUser);

}
