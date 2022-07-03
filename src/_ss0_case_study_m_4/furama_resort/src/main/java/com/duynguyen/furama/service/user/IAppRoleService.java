package com.duynguyen.furama.service.user;

import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.model.user.Role;

import java.util.List;

public interface IAppRoleService {
    List<Role> findAllRoles();

    Role findRole(int i);

    void saveRole(Employee employee);
}
