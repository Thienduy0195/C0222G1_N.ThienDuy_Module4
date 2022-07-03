package com.duynguyen.furama.service.user;

import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.model.user.Role;
import com.duynguyen.furama.model.user.User;

public interface IUserRoleService {

    void saveUser(Employee employee, User employeeUser);

    void saveUserRole(Employee employee, User employeeUser, Role userRole, Role adminRole);
}
