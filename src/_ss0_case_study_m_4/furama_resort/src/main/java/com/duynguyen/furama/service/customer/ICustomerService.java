package com.duynguyen.furama.service.customer;

import com.duynguyen.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAllByName(String keywordName, Pageable pageable);

    List<String> getCustomerCode();

    void save(Customer customer);

    Page<Customer> findAllByNameAndCodeAndType(String keywordName, String keywordCode, String keywordType, Pageable pageable);

    Customer findById(Integer id);

    void delete(Customer customer);

    void deleteById(Integer id);

    List<Customer> findAll();

    List<String> getEmail();

    List<String> getPhone();

    List<String> getIdCard();

    Page<Customer> findAllPageable(Pageable pageable);

}
