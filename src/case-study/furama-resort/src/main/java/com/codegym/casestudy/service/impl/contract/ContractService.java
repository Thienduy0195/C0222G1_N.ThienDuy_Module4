package com.codegym.casestudy.service.impl.contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.repository.contract.IContractRepository;
import com.codegym.casestudy.service.interface_contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findAllBy(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }
}
