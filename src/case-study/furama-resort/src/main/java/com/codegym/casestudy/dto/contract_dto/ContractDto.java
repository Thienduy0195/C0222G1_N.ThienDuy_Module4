package com.codegym.casestudy.dto.contract_dto;

import com.codegym.casestudy.dto.customer_dto.AdvanceInfo;
import com.codegym.casestudy.dto.customer_dto.BasicInfo;
import com.codegym.casestudy.dto.customer_dto.Thrid;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@GroupSequence({ContractDto.class, BasicInfo.class, AdvanceInfo.class, Thrid.class})
public class ContractDto implements Validator {
    private Integer id;
    @NotBlank(message = "*choose date", groups = BasicInfo.class)
    private String dateStart;
    @NotBlank(message = "*choose date", groups = BasicInfo.class)
    private String dateEnd;
    @NotBlank(message = "*enter deposit", groups = BasicInfo.class)
    @Pattern(regexp = "[1-9]{1}[0-9]*", message = "*enter number type", groups = AdvanceInfo.class)
    private String deposit;
    private String totalMoney;
    @NotNull(message = "*choose employee", groups = BasicInfo.class)
    private Employee employee;
    @NotNull(message = "*choose customer", groups = BasicInfo.class)
    private Customer customer;
    @NotNull(message = "*choose service", groups = BasicInfo.class)
    private Service service;

    public ContractDto() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if (!"".equals(contractDto.getDateStart()) && !"".equals(contractDto.getDateEnd())) {
            LocalDate dateStart = LocalDate.parse(contractDto.getDateStart());
            LocalDate dateEnd = LocalDate.parse(contractDto.getDateEnd());
            if (dateEnd.isBefore(dateStart)) {
                errors.rejectValue("dateStart", "date.contract.valid", "errors");
                errors.rejectValue("dateEnd", "date.contract.valid", "errors");
            }
        }
    }
}
