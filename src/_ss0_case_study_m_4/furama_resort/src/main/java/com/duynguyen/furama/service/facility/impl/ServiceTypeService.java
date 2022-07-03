package com.duynguyen.furama.service.facility.impl;

import com.duynguyen.furama.model.service.ServiceType;
import com.duynguyen.furama.repository.facility.IServiceTypeRepository;
import com.duynguyen.furama.service.facility.IServiceType;
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
