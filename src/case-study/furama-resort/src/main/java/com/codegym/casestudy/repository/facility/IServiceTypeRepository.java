package com.codegym.casestudy.repository.facility;

import com.codegym.casestudy.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
