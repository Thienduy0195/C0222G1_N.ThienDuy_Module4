package com.codegym.casestudy.service.impl.facility;

import com.codegym.casestudy.model.service.ServiceType;
import com.codegym.casestudy.repository.facility.IServiceTypeRepository;
import com.codegym.casestudy.service.interface_facility.IServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceType {
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
