package com.codegym.casestudy.repository.facility;

import com.codegym.casestudy.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
