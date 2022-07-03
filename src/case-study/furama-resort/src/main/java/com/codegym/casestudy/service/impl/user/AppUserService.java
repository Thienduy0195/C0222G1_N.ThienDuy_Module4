package com.codegym.casestudy.service.impl.user;

import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.user.AppUser;
import com.codegym.casestudy.repository.user.AppUserRepository;
import com.codegym.casestudy.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    AppUser findUser(String email){
        return this.appUserRepository.findByUsername(email);
    }

}
