package com.duynguyen.furama.dto.customer_dto;

public interface CustomerDtoJoin {
    Integer getCustomerId();

    Integer getContractId();

    String getName();

    String getServiceInclude();

    String getDateStart();

    String getDateEnd();

    Long getCost();
}

