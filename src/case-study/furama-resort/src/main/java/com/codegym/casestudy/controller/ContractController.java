package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.contract_dto.ContractDto;
import com.codegym.casestudy.dto.customer_dto.CustomerDto;
import com.codegym.casestudy.dto.service_dto.ServiceDto;
import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.service.interface_contract.IContractService;
import com.codegym.casestudy.service.interface_customer.ICustomerService;
import com.codegym.casestudy.service.interface_employee.IEmployeeService;
import com.codegym.casestudy.service.interface_facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    
    @Autowired
    IContractService iContractService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IFacilityService iFacilityService;

    @GetMapping()
    public String goContractPage(Model model,
                                 @RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "3") Integer pageSize,
                                 @RequestParam Optional<String> sort,
                                 @RequestParam Optional<String> dir) {
        Pageable pageable;
        String dirVal = dir.orElse("");
        String sortVal = sort.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if ("asc".equals(dirVal)) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }
        model.addAttribute("contracts", this.iContractService.findAllBy(pageable));
        model.addAttribute("sumService",this.iCustomerService.findCustomerBooking(pageable));
        model.addAttribute("sortVal", sortVal);
        model.addAttribute("dirVal", dirVal);
        return "contract/contract_list";
    }

    @GetMapping("/goCreate")
    public String goCreateContract(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customers", iCustomerService.findAll());
        model.addAttribute("employees",iEmployeeService.findAll() );
        model.addAttribute("facility",iFacilityService.findAll());
        return "contract/create_contract";
    }

    @PostMapping("/save")
    public String createFacility(@ModelAttribute @Validated ContractDto contractDto,
                                 BindingResult bindingResult,
                                 Model model){
        new ContractDto().validate(contractDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customers", iCustomerService.findAll());
            model.addAttribute("employees",iEmployeeService.findAll() );
            model.addAttribute("facility",iFacilityService.findAll());
            return "contract/create_contract";
        }else{
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            this.iContractService.save(contract);
            return "redirect:/contract";
        }
    }
}
