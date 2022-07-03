package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = " select * from employee where `name` like :searchName and division_id " +
                    "like :searchDivision and  position_id like :searchPosition and  education_degree_id like :searchEdu and flag = 1",
            countQuery = "select * from employee where `name` like :searchName and division_id " +
                    "like :searchDivision and  position_id like:searchPosition and  education_degree_id like:searchEdu and flag = 1",
            nativeQuery = true)
    Page<Employee> findAllByQuery(@Param("searchName") String name,
                                  @Param("searchDivision") String divisionKey,
                                  @Param("searchPosition") String positionKey,
                                  @Param("searchEdu") String educationKey,
                                  Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update employee set flag = 0 where employee_id = :idDelete",
            nativeQuery = true)
    void softDelete(@Param("idDelete") Integer id);

    @Modifying
    @Transactional
    @Query(value = "update employee set flag = 0 where employee_id in (?1)",
            nativeQuery = true)
    void deleteCheck(List<Integer> asList);


    Employee findFirstByEmail(String email);

    Employee findFirstByPhone(String phone);

    Employee findFirstByIdCard(String idCard);
}
