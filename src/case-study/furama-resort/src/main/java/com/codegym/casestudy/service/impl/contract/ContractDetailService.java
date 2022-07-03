package com.codegym.casestudy.service.impl.contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import com.codegym.casestudy.repository.contract.IContractDetailRepository;
import com.codegym.casestudy.service.interface_contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository iContractDetailRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
      return this.iContractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        this.iContractDetailRepository.save(contractDetail);
    }
}
