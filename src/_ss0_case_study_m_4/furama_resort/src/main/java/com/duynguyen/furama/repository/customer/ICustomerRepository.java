package com.duynguyen.furama.repository.customer;

import com.duynguyen.furama.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where status=1", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select email from customer", nativeQuery = true)
    List<String> getCustomerEmail();

    @Query(value = "select phone from customer", nativeQuery = true)
    List<String> getCustomerPhone();

    @Query(value = "select id_card from customer", nativeQuery = true)
    List<String> getCustomerIdCard();
}
