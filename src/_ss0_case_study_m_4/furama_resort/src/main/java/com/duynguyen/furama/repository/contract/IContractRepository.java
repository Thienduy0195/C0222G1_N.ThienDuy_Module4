package com.duynguyen.furama.repository.contract;

import com.duynguyen.furama.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
}
