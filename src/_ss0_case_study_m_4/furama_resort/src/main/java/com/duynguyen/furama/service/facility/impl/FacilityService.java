package com.duynguyen.furama.service.facility.impl;

import com.duynguyen.furama.dto.service_dto.ServiceDto;
import com.duynguyen.furama.model.service.Service;
import com.duynguyen.furama.repository.facility.IFacilityRepository;
import com.duynguyen.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

@org.springframework.stereotype.Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;

    @Override
    public List<Service> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Page<Service> findAllPageable(Pageable pageable) {
        return iFacilityRepository.findAllPageable(pageable);
    }

    @Override
    public Service findById(Integer id) {
        return iFacilityRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public void save(Service service) {
        this.iFacilityRepository.save(service);
    }

    @Override
    public void checkExists(ServiceDto serviceDto, BindingResult bindingResult) {
        Service exitsService;
        if (!"".equals(serviceDto.getServiceCode())) {
            if (!serviceDto.getServiceCode().matches("(^DV-[0-9]{4}$)")) {
                bindingResult.rejectValue("serviceCode", "service.code.format", "Wrong format (DV-XXXX)!");
            } else {
                exitsService = this.iFacilityRepository.findFirstByServiceCode(serviceDto.getServiceCode());
                if (exitsService != null) {
                    bindingResult.rejectValue("serviceCode", "service.code.duplicate", "This service code already exist!");
                }
            }
        }else {
            bindingResult.rejectValue("serviceCode", "service.code.null", "This service code must be not empty!");
        }
    }
}

