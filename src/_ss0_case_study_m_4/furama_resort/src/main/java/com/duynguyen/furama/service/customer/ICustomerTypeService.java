package com.duynguyen.furama.service.customer;

import com.duynguyen.furama.model.customer.CustomerType;
import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
