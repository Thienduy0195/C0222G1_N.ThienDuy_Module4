package com.duynguyen.furama.dto.service_dto;

import com.duynguyen.furama.dto.contract_dto.ContractDto;
import com.duynguyen.furama.dto.customer_dto.AdvanceInfo;
import com.duynguyen.furama.dto.customer_dto.BasicInfo;
import com.duynguyen.furama.model.service.RentType;
import com.duynguyen.furama.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@GroupSequence({ServiceDto.class, BasicInfo.class, AdvanceInfo.class})
public class ServiceDto implements Validator {

    private Integer id;
    @NotBlank(message = "*Please enter name!")
    private String name;

    @NotBlank(message = "*enter area")
    @Pattern(regexp = "^[0-9]+$", message = "Invalid service area!")
    private String area;

    @NotBlank(message = "*enter cost")
    @Pattern(regexp = "^[0-9]+$", message = "Invalid service cost!")
    private String cost;

    @NotBlank(message = "not null")
    @Pattern(regexp = "^[0-9]+$", message = "Invalid service max people!")
    private String maxPeople;

    @NotBlank(message = "not null")
    private String standardRoom;

    @NotBlank(message = "not null")
    private String otherConvenience;

    @NotBlank(message = "not null")
    @Pattern(regexp = "^[0-9]+$", message = "Pool area must be a positive number!")
    private String poolArea;

    @NotBlank(message = "not null")
    @Pattern(regexp = "^[0-9]+$", message = "Number of floor must be a positive number!")
    private String numOfFloor;

    @NotBlank(message = "not null")
    private String serviceCode;

    List<ContractDto> contractDtoList;

    @NotNull(message = "choose service type")
    private ServiceType serviceType;

    @NotNull(message = "choose rent type")
    private RentType rentType;

    public ServiceDto() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(String numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public List<ContractDto> getContractDtoList() {
        return contractDtoList;
    }

    public void setContractDtoList(List<ContractDto> contractDtoList) {
        this.contractDtoList = contractDtoList;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
    }
}
