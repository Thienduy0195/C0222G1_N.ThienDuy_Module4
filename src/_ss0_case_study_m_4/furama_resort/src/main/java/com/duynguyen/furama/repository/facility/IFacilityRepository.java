package com.duynguyen.furama.repository.facility;

import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Service, Integer> {

    Service findFirstByServiceCode(String serviceCode);

    @Query(value = "select * from service where status=1", nativeQuery = true)
    Page<Service> findAllPageable(Pageable pageable);

    @Modifying
    @Query(value = "update service set status = 0 where id = :idDelete",
            nativeQuery = true)
    void deleteById(@Param("idDelete") Integer id);
}
