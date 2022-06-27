package com.duynguyen.furama.repository.employee;


import com.duynguyen.furama.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
