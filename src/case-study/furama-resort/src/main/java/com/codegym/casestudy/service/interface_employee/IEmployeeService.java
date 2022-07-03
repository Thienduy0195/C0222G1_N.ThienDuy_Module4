package com.codegym.casestudy.service.interface_employee;

import com.codegym.casestudy.dto.employee_dto.EmployeeDto;
import com.codegym.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(String keywordName, String divisionKey, String positionKey, String educationDegreeKey, Pageable pageable);

    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(Integer id);

    void softDelete(Integer id);

    void deleteCheck(Integer[] idCheck);

    void checkExists(EmployeeDto employeeDto, BindingResult bindingResult);
}
