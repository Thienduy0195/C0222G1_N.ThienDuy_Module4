package com.codegym.validate_form.service.impl;

import com.codegym.validate_form.model.User;
import com.codegym.validate_form.repository.IUserRepository;
import com.codegym.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
