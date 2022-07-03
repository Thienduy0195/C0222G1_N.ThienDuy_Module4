package com.duynguyen.furama.repository.customer;

import com.duynguyen.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where status=1", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select * from customer where status=1", nativeQuery = true)
    Page<Customer> findAllPageable(Pageable pageable);

    @Modifying
    @Query(value = "update customer set status = 0 where id = :idDelete",
            nativeQuery = true)
    void deleteById(@Param("idDelete") Integer id);

    @Query(value = "select customer_code from customer", nativeQuery = true)
    List<String> getCustomerCode();

    @Query(value = "select email from customer", nativeQuery = true)
    List<String> getCustomerEmail();

    @Query(value = "select phone from customer", nativeQuery = true)
    List<String> getCustomerPhone();

    @Query(value = "select id_card from customer", nativeQuery = true)
    List<String> getCustomerIdCard();


}
