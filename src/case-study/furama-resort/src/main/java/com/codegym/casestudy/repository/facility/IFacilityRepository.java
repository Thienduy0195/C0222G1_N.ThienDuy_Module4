package com.codegym.casestudy.repository.facility;

import com.codegym.casestudy.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Service,Integer> {

    Service findFirstByServiceCode(String serviceCode);
}
