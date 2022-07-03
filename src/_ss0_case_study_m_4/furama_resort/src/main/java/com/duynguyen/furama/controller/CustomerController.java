package com.duynguyen.furama.controller;

import com.duynguyen.furama.dto.customer_dto.CustomerDto;
import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.model.customer.CustomerType;
import com.duynguyen.furama.service.customer.ICustomerService;
import com.duynguyen.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Sort sort = Sort.by("customer").ascending();
        Page<Customer> customerList = customerService.findAllPageable(PageRequest.of(page, 10));
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerList", customerList);
        return "customer/customer-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/create-customer";
    }

    @PostMapping("/save")
    public String createCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 Model model) {
        customerDto.setCustomerCodeList(this.customerService.getCustomerCode());
        customerDto.setEmailList(this.customerService.getEmail());
        customerDto.setPhoneList(this.customerService.getPhone());
        customerDto.setIdCardList(this.customerService.getIdCard());
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", this.customerTypeService.findAll());
            return "customer/create-customer";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setStatus(1);
            this.customerService.save(customer);
            return "redirect:/customer";
        }
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         Model model) {
        Customer customer = customerService.findById(customerDto.getId());
        customer.setPhone(null);
        customer.setEmail(null);
        customer.setCustomerCode(null);
        customer.setIdCard(null);
        customerService.save(customer);
        customerDto.setCustomerCodeList(this.customerService.getCustomerCode());
        customerDto.setEmailList(this.customerService.getEmail());
        customerDto.setPhoneList(this.customerService.getPhone());
        customerDto.setIdCardList(this.customerService.getIdCard());
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", this.customerTypeService.findAll());
            return "customer/update";
        } else {
            Customer newCustomer = new Customer();
            BeanUtils.copyProperties(customerDto, newCustomer);
            newCustomer.setStatus(1);
            this.customerService.save(newCustomer);
            return "redirect:/customer";
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id) {
        this.customerService.deleteById(id);
        return "redirect:/customer";
    }


}
