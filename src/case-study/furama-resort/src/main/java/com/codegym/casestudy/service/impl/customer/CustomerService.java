package com.codegym.casestudy.service.impl.customer;

import com.codegym.casestudy.dto.customer_dto.CustomerDtoJoin;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.repository.customer.ICustomerRepository;
import com.codegym.casestudy.service.interface_customer.ICustomerService;
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
        return this.iCustomerRepository.findAllByNameContaining(keywordName, pageable);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllByNameAndCodeAndType(String keywordName, String keywordCode, String keywordType, Pageable pageable) {
        return this.iCustomerRepository.findAllByNameContainingAndCustomerCodeContainingAndCustomerType_Name(keywordName, keywordCode, keywordType, pageable);
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
    public Page<Customer> findAllByNameCodeType(String keywordName, String keywordCode, String keywordType, Pageable pageable) {
        return this.iCustomerRepository.findAllByNameCodeType("%" + keywordName + "%", "%" + keywordCode + "%", keywordType, pageable);
    }

    @Override
    public Page<CustomerDtoJoin> findCustomerBooking(Pageable pageable) {
        return this.iCustomerRepository.findCustomerJoin(pageable);
    }

    @Override
    public List<String> getCustomerCode() {
        return this.iCustomerRepository.getCustomerCode();
    }
    @Override
    public List<String> getEmail() {
        return this.iCustomerRepository.getEmail();
    }

    @Override
    public List<String> getPhone() {
        return this.iCustomerRepository.getPhone();
    }

    @Override
    public List<String> getIdCard() {
        return this.iCustomerRepository.getIdCard();
    }

    @Override
    public Page<Customer> getAllApi(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }


}
