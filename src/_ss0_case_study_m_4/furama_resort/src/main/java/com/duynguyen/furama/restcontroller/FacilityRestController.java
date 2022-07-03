package com.duynguyen.furama.restcontroller;

import com.duynguyen.furama.model.service.Service;
import com.duynguyen.furama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facility")
public class FacilityRestController {

    @Autowired
    IFacilityService facilityService;

    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable("id") Integer id){
        Service service = this.facilityService.findById(id);
        if(service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }
}
