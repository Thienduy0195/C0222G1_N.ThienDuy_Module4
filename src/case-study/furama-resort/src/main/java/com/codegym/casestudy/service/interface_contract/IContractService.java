package com.codegym.casestudy.service.interface_contract;

import com.codegym.casestudy.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();


    Page<Contract> findAllBy(Pageable pageable);

    void save(Contract contract);
}
