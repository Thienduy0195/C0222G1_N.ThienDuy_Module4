package com.codegym.casestudy.service.impl.facility;

import com.codegym.casestudy.model.service.RentType;
import com.codegym.casestudy.repository.facility.IRentTypeRepository;
import com.codegym.casestudy.service.interface_facility.IRentTypeService;
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
