package com.codegym.casestudy.service.interface_customer;

import com.codegym.casestudy.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    List<CustomerType> findAll();
}
