package com.duynguyen.furama.service.customer.impl;

import com.duynguyen.furama.model.customer.CustomerType;
import com.duynguyen.furama.repository.customer.ICustomerTypeRepository;
import com.duynguyen.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
