package com.duynguyen.furama.service.facility.impl;

import com.duynguyen.furama.model.service.RentType;
import com.duynguyen.furama.repository.facility.IRentTypeRepository;
import com.duynguyen.furama.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
