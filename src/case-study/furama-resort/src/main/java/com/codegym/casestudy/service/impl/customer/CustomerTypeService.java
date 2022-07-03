package com.codegym.casestudy.service.impl.customer;

import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.repository.customer.ICustomerTypeRepository;
import com.codegym.casestudy.service.interface_customer.ICustomerTypeService;
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
