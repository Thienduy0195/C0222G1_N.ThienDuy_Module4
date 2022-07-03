package com.duynguyen.furama.service.user.impl;

import com.duynguyen.furama.model.user.User;
import com.duynguyen.furama.repository.user.IUserRepository;
import com.duynguyen.furama.service.user.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    IUserRepository appUserRepository;

    User findUser(String email){
        return this.appUserRepository.findByUsername(email);
    }

}
