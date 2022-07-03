package com.duynguyen.furama.service.user.impl;


import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.model.user.Role;
import com.duynguyen.furama.repository.user.IRoleRepository;
import com.duynguyen.furama.service.user.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IRoleRepository appRoleRepository;

    @Override
    public List<Role> findAllRoles() {
        return this.appRoleRepository.findAll();
    }

    @Override
    public Role findRole(int i) {
        return this.appRoleRepository.findById(i).orElse(null);
    }

    @Override
    public void saveRole(Employee employee) {

    }
}
