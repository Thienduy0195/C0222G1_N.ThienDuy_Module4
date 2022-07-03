package com.duynguyen.furama.service.emloyee;


import com.duynguyen.furama.dto.employee_dto.EmployeeDto;
import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Page<Employee> findAllPageable(Pageable pageable);

    void save(Employee employee);

    void delete(Employee employee);

    Employee findById(Integer id);

    void softDelete(Integer id);

    void deleteCheck(Integer[] idCheck);

    void checkExists(EmployeeDto employeeDto, BindingResult bindingResult);
}
