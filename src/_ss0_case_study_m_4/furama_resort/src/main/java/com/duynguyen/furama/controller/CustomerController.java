package com.duynguyen.furama.controller;


import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.model.customer.CustomerType;
import com.duynguyen.furama.service.customer.ICustomerService;
import com.duynguyen.furama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Customer> customerList = customerService.findAll();
//        Page<Customer> customerList = customerService.findAllPageable(PageRequest.of(page, 3));
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerList", customerList);
        return "customer/customer-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer/create-customer";
    }

    @PostMapping("/save")
    public String SaveObject(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        customer.setStatus(1);
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Create blog successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList",customerTypeList);
        return "/customer/update";
    }

    @PostMapping("/update")
    public String updateObject(Customer customer, RedirectAttributes redirect) {
        customer.setStatus(1);
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Updating customer successfully!");
        return "redirect:/customer";
    }

}
