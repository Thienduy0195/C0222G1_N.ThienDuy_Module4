package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
