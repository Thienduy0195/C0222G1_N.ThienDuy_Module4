package com.duynguyen.furama.repository.employee;

import com.duynguyen.furama.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
