package com.codegym.casestudy.rest;

import com.codegym.casestudy.dto.customer_dto.CustomerDto;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.service.interface_customer.ICustomerService;
import com.codegym.casestudy.service.interface_customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerRestController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/list")
    public ResponseEntity<Page<Customer>> getPageCustomer(@PageableDefault(size = 5) Pageable pageable) {
        Page<Customer> customers = this.customerService.getAllApi(pageable);
        if (!customers.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createCustomer(@Validated @RequestBody CustomerDto customerDto,
                                                              BindingResult bindingResult) {
        System.out.println(customerDto);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        BeanUtils.copyProperties(customerDto, customer);
        BeanUtils.copyProperties(customerType, customerDto.getCustomerType());
        customer.setCustomerType(customerType);
        this.customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/customer_type_list")
    public ResponseEntity<Iterable<CustomerType>> showCustomerTypeList() {
        return new ResponseEntity<>(customerTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer id){
        Customer customer = this.customerService.findById(id);
        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Integer id){
        Customer customer = this.customerService.findById(id);
        System.out.println(customer);
        if(customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.customerService.delete(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PatchMapping(value = "update/{id}")
    public ResponseEntity<Map<String, String>> updateCustomer(@PathVariable("id") Integer id,
                                                              @Validated @RequestBody CustomerDto customerDto,
                                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.OK);
        }
        Customer customer = new Customer();
        CustomerType customerType = new CustomerType();
        BeanUtils.copyProperties(customerDto, customer);
        BeanUtils.copyProperties(customerDto.getCustomerType(), customerType);
        customer.setId(id);
        customer.setCustomerType(customerType);
        this.customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
