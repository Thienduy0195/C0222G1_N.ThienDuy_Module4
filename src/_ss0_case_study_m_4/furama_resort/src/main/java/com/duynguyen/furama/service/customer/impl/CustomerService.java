package com.duynguyen.furama.service.customer.impl;

import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.repository.customer.ICustomerRepository;
import com.duynguyen.furama.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllByName(String keywordName, Pageable pageable) {
        return null;
//        return this.iCustomerRepository.findAllByNameContaining(keywordName, pageable);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllByNameAndCodeAndType(String keywordName, String keywordCode, String keywordType, Pageable pageable) {
        return null;
//        return this.iCustomerRepository.findAllByNameContainingAndCustomerCodeContainingAndCustomerType_Name(keywordName, keywordCode, keywordType, pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        this.iCustomerRepository.deleteById(customer.getId());
    }

    @Override
    public void deleteById(Integer id) {
        this.iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public List<String> getCustomerCode() {
        return this.iCustomerRepository.getCustomerCode();
    }

    @Override
    public List<String> getEmail() {
        return this.iCustomerRepository.getCustomerEmail();
    }

    @Override
    public List<String> getPhone() {
        return this.iCustomerRepository.getCustomerPhone();
    }

    @Override
    public List<String> getIdCard() {
                return this.iCustomerRepository.getCustomerIdCard();
    }

    @Override
    public Page<Customer> findAllPageable(Pageable pageable) {
        return this.iCustomerRepository.findAllPageable(pageable);
    }


}
