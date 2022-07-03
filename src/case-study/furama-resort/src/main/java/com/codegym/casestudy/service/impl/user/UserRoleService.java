package com.codegym.casestudy.service.impl.user;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.user.AppRole;
import com.codegym.casestudy.model.user.AppUser;
import com.codegym.casestudy.model.user.UserRole;
import com.codegym.casestudy.repository.user.AppRoleRepository;
import com.codegym.casestudy.repository.user.AppUserRepository;
import com.codegym.casestudy.repository.user.UserRoleRepository;
import com.codegym.casestudy.service.IUserRoleService;
import com.codegym.casestudy.util.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;


    @Override
    public void saveUser(Employee employee, AppUser employeeUser) {
        employeeUser.setUsername(employee.getEmail());
        employeeUser.setEnabled(true);
        String password = EncrytedPasswordUtils.encrytePassword("123");
        employeeUser.setEncrytedPassword(password);
        this.appUserRepository.save(employeeUser);
    }

    @Override
    public void saveUserRole(Employee employee, AppUser employeeUser, AppRole userRole, AppRole adminRole) {
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
