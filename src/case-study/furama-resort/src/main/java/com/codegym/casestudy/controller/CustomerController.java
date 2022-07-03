package com.codegym.casestudy.controller;


import com.codegym.casestudy.dto.customer_dto.CustomerDto;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.service.interface_customer.ICustomerService;
import com.codegym.casestudy.service.interface_customer.ICustomerTypeService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;
    @GetMapping()
    public String goCustomerPage(Model model,
                                 @RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "3") Integer pageSize,
                                 @RequestParam Optional<String> sort,
                                 @RequestParam Optional<String> dir,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<String> customerCode,
                                 @RequestParam Optional<String> customerType){
        Pageable pageable;
        String keywordName = name.orElse("");
        String keywordCode = customerCode.orElse("");
        String keywordType = customerType.orElse("%");
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
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
//        model.addAttribute("customers", this.customerService.findAllByName(keywordName, pageable));
        model.addAttribute("customers", this.customerService.findAllByNameCodeType(keywordName, keywordCode,keywordType,pageable));
        model.addAttribute("keywordName", keywordName);
        model.addAttribute("sortVal", sortVal);
        model.addAttribute("dirVal", dirVal);
        return "customer/customer_list";
    }

    @GetMapping("/goCreate")
    public String goCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        return "customer/create_customer";
    }

    @PostMapping("/save")
    public String createCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 Model model){
        customerDto.setCustomerCodeList(this.customerService.getCustomerCode());
        customerDto.setEmailList(this.customerService.getEmail());
        customerDto.setPhoneList(this.customerService.getPhone());
        customerDto.setIdCardList(this.customerService.getIdCard());
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            return "customer/create_customer";
        }else{
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.customerService.save(customer);
            return "redirect:/customer";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id){
        this.customerService.deleteById(id);
        return  "redirect:/customer";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Integer id,Model model){
        Customer customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/detail_customer";
    }

    @GetMapping("/edit")
    public String goEdit(@RequestParam Integer id,Model model){
        Customer customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        model.addAttribute("customerTypes", this.customerTypeService.findAll());
        return "customer/edit_customer";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model){
        customerDto.setCustomerCodeList(this.customerService.getCustomerCode());
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customerTypes", this.customerTypeService.findAll());
            return "customer/edit_customer";
        }else{
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.customerService.save(customer);
            return "redirect:/customer";
        }
    }
    @GetMapping("customer-have-booking")
    public String goCustomerHaveBooking(Model model,
                                        @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "3") Integer pageSize,
                                        @RequestParam Optional<String> sort,
                                        @RequestParam Optional<String> dir,
                                        @RequestParam Optional<String> name){
        Pageable pageable;
        String dirVal = dir.orElse("");
        String sortVal = sort.orElse("");
        String keywordName = name.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if ("asc".equals(dirVal)) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }
        model.addAttribute("customerDtoJoins",   this.customerService.findCustomerBooking(pageable));
        return "customer/customer_have_booking";
    }

}
