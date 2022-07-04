package com.duynguyen.furama.controller;

import com.duynguyen.furama.dto.service_dto.ServiceDto;
import com.duynguyen.furama.model.service.Service;
import com.duynguyen.furama.service.facility.IFacilityService;
import com.duynguyen.furama.service.facility.IRentTypeService;
import com.duynguyen.furama.service.facility.IServiceType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IServiceType iServiceType;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Sort sort = Sort.by("customer").ascending();
        Page<Service> facilityList = iFacilityService.findAllPageable(PageRequest.of(page, 5));
        model.addAttribute("facility", new Service());
        model.addAttribute("facilityList", facilityList);
        return "facility/facility-list";
    }

    @GetMapping("/goCreate")
    public String goCreateCustomer(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        model.addAttribute("serviceTypeList", this.iServiceType.findAll());
        //tới đây
        return "/facility/create-facility";
    }

    @PostMapping("/save")
    public String createFacility(@ModelAttribute @Validated ServiceDto serviceDto,
                                 BindingResult bindingResult,
                                 Model model) {
        new ServiceDto().validate(serviceDto, bindingResult);
        this.iFacilityService.checkExists(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
            model.addAttribute("serviceTypeList", this.iServiceType.findAll());
            return "/facility/create-facility";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            this.iFacilityService.save(service);
            return "redirect:/facility";
        }
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Service service = iFacilityService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service, serviceDto);
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        model.addAttribute("serviceTypeList", this.iServiceType.findAll());
        model.addAttribute("serviceDto", serviceDto);
        return "/facility/update-facility";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated ServiceDto serviceDto,
                         BindingResult bindingResult,
                         Model model) {
        Service service = iFacilityService.findById(serviceDto.getId());
        service.setServiceCode(null);
        iFacilityService.save(service);
        new ServiceDto().validate(serviceDto, bindingResult);
        this.iFacilityService.checkExists(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
            model.addAttribute("serviceTypeList", this.iServiceType.findAll());
            return "/facility/update-facility";
        } else {
            Service newService = new Service();
            BeanUtils.copyProperties(serviceDto, newService);
            this.iFacilityService.save(newService);
            return "redirect:/facility";
        }
    }

    @PostMapping("/delete")
    public String deleteFacility(@RequestParam Integer id) {
        this.iFacilityService.deleteById(id);
        return "redirect:/facility";
    }
}
