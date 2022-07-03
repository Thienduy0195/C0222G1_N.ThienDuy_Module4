package com.duynguyen.furama.service.user.impl;

import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.model.user.Role;
import com.duynguyen.furama.model.user.User;
import com.duynguyen.furama.model.user.UserRole;
import com.duynguyen.furama.repository.user.IRoleRepository;
import com.duynguyen.furama.repository.user.IUserRepository;
import com.duynguyen.furama.repository.user.IUserRoleRepository;
import com.duynguyen.furama.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRepository appUserRepository;

    @Autowired
    private IUserRoleRepository userRoleRepository;

    @Autowired
    private IRoleRepository appRoleRepository;


    @Override
    public void saveUser(Employee employee, User employeeUser) {
        employeeUser.setUsername(employee.getEmail());
//        employeeUser.setEnabled(true);
//        String password = EncrytedPasswordUtils.encrytePassword("123");
//        employeeUser.setEncrytedPassword(password);
        this.appUserRepository.save(employeeUser);
    }

    @Override
    public void saveUserRole(Employee employee, User employeeUser, Role userRole, Role adminRole) {
        if(employee.getPosition().getPositionId() == 1){
            UserRole employeeRoleAdmin = new UserRole();
            employeeRoleAdmin.setRole(adminRole);
            employeeRoleAdmin.setUser(employeeUser);
            this.userRoleRepository.save(employeeRoleAdmin);
        }
        UserRole employeeRoleUser = new UserRole();
        employeeRoleUser.setRole(userRole);
        employeeRoleUser.setUser(employeeUser);
        this.userRoleRepository.save(employeeRoleUser);
    }
}
