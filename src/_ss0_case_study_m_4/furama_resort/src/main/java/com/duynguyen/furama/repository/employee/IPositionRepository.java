package com.duynguyen.furama.repository.employee;

import com.duynguyen.furama.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
