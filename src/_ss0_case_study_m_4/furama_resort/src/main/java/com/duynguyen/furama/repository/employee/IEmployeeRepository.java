package com.duynguyen.furama.repository.employee;

import com.duynguyen.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from employee where status=1", nativeQuery = true)
    List<Employee> findAll();

    @Query(value = "select * from employee where status=1", nativeQuery = true)
    Page<Employee> findAllPageable(Pageable pageable);

    @Modifying
    @Query(value = "update employee set status = 0 where employee_id = :idDelete",
            nativeQuery = true)
    void softDelete(@Param("idDelete") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update employee set status = 0 where employee_id in (?1)",
            nativeQuery = true)
    void deleteCheck(List<Integer> asList);


    Employee findFirstByEmail(String email);

    Employee findFirstByPhone(String phone);

    Employee findFirstByIdCard(String idCard);
}
