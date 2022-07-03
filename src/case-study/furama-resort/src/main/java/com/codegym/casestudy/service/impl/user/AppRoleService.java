package com.codegym.casestudy.service.impl.user;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.user.AppRole;
import com.codegym.casestudy.repository.user.AppRoleRepository;
import com.codegym.casestudy.service.IAppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public List<AppRole> findAllRoles() {
        return this.appRoleRepository.findAll();
    }

    @Override
    public AppRole findRole(int i) {
        return this.appRoleRepository.findById(i).orElse(null);
    }

    @Override
    public void saveRole(Employee employee) {

    }
}
