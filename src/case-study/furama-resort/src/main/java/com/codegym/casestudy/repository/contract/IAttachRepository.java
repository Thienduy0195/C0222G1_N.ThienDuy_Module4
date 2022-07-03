package com.codegym.casestudy.repository.contract;

import com.codegym.casestudy.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository extends JpaRepository<AttachService,Integer> {
}
