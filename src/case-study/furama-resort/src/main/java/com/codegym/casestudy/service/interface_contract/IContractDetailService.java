package com.codegym.casestudy.service.interface_contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);
}
