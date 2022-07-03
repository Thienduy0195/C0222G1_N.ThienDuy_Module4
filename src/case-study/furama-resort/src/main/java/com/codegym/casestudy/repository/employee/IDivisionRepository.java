package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
