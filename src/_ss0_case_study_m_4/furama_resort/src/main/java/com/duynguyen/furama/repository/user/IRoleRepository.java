package com.duynguyen.furama.repository.user;

import com.duynguyen.furama.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
