package com.codegym.casestudy.dto.contract_dto;

import com.codegym.casestudy.model.contract.AttachService;
import com.codegym.casestudy.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDetailDto implements Validator {
    private Integer id;
    private String quantity;
    private AttachService attachService;
    private Contract contract;
    public ContractDetailDto() {
    }

    public ContractDetailDto(Integer id, String quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
