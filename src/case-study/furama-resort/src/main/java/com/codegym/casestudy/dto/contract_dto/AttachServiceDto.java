package com.codegym.casestudy.dto.contract_dto;

import java.util.List;

public class AttachServiceDto {
    private Integer id;
    private String name;
    private String cost;
    private String unit;
    private String status;
    List<ContractDetailDto> contractDetailDtoList;

    public AttachServiceDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ContractDetailDto> getContractDetailDtoList() {
        return contractDetailDtoList;
    }

    public void setContractDetailDtoList(List<ContractDetailDto> contractDetailDtoList) {
        this.contractDetailDtoList = contractDetailDtoList;
    }
}
