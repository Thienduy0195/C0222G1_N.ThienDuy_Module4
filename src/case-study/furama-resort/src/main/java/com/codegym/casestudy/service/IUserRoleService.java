package com.codegym.casestudy.service;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.user.AppRole;
import com.codegym.casestudy.model.user.AppUser;

public interface IUserRoleService {
    

    void saveUser(Employee employee, AppUser employeeUser);

    void saveUserRole(Employee employee, AppUser employeeUser, AppRole userRole, AppRole adminRole);
}
