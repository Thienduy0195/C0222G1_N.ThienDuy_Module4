package com.codegym.casestudy.service.interface_facility;

import com.codegym.casestudy.dto.service_dto.ServiceDto;
import com.codegym.casestudy.model.service.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IFacilityService {
    List<Service> findAll();

    void save(Service service);

    void checkExists(ServiceDto serviceDto, BindingResult bindingResult);
}
