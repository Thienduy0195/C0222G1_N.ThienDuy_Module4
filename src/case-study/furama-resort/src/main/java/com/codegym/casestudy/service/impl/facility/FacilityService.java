package com.codegym.casestudy.service.impl.facility;

import com.codegym.casestudy.dto.service_dto.ServiceDto;
import com.codegym.casestudy.repository.facility.IFacilityRepository;
import com.codegym.casestudy.service.interface_facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;

    @Override
    public List<com.codegym.casestudy.model.service.Service> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(com.codegym.casestudy.model.service.Service service) {
        this.iFacilityRepository.save(service);
    }

    @Override
    public void checkExists(ServiceDto serviceDto, BindingResult bindingResult) {
        com.codegym.casestudy.model.service.Service exitsService =
                this.iFacilityRepository.findFirstByServiceCode(serviceDto.getServiceCode());
        if (serviceDto.getId() == null) {

            if (!"".equals(serviceDto.getServiceCode())) {
                if (exitsService != null) {
                    bindingResult.rejectValue("serviceCode", "service.code.duplicate", "errors");
                }
            }

        } else {
            if (exitsService != null) {
                if (!exitsService.getId().equals(serviceDto.getId())) {
                    bindingResult.rejectValue("serviceCode", "service.code.duplicate", "errors");
                }
            }
        }
    }

}

