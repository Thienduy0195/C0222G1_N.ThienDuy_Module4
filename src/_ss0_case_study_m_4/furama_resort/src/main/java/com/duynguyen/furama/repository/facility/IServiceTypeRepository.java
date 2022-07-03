package com.duynguyen.furama.repository.facility;

import com.duynguyen.furama.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
