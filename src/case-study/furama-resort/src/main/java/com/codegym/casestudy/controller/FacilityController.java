package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.customer_dto.CustomerDto;
import com.codegym.casestudy.dto.service_dto.ServiceDto;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.service.interface_facility.IFacilityService;
import com.codegym.casestudy.service.interface_facility.IRentTypeService;
import com.codegym.casestudy.service.interface_facility.IServiceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IServiceType iServiceType;
    @Autowired
    private IRentTypeService iRentTypeService;
    @GetMapping()
    public String goFacilityPage(Model model) {
        model.addAttribute("facilities",this.iFacilityService.findAll());
        return "facility/facility_list";
    }

    @GetMapping("/goCreate")
    public String goCreateCustomer(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("rentType",this.iRentTypeService.findAll());
        model.addAttribute("serviceType", this.iServiceType.findAll());
        //tới đây
        return "facility/create_facility";
    }

    @PostMapping("/save")
    public String createFacility(@ModelAttribute @Validated ServiceDto serviceDto,
                                 BindingResult bindingResult,
                                 Model model){
        new ServiceDto().validate(serviceDto,bindingResult);
        this.iFacilityService.checkExists(serviceDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("rentType",this.iRentTypeService.findAll());
            model.addAttribute("serviceType", this.iServiceType.findAll());
            return "facility/create_facility";
        }else{
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            this.iFacilityService.save(service);
            return "redirect:/facility";
        }
    }
}
