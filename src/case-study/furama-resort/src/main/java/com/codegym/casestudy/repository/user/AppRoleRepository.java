package com.codegym.casestudy.repository.user;

import com.codegym.casestudy.model.user.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Integer> {
}
