package com.codegym.casestudy.service;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.user.AppRole;

import java.util.List;

public interface IAppRoleService {
    List<AppRole> findAllRoles();

    AppRole findRole(int i);

    void saveRole(Employee employee);
}
