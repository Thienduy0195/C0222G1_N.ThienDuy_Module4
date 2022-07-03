package com.duynguyen.furama.service.facility;

import com.duynguyen.furama.dto.service_dto.ServiceDto;
import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IFacilityService {
    List<Service> findAll();

    Page<Service> findAllPageable(Pageable pageable);

    void save(Service service);

    void checkExists(ServiceDto serviceDto, BindingResult bindingResult);

    Service findById(Integer id);

    void deleteById(Integer id);
}
