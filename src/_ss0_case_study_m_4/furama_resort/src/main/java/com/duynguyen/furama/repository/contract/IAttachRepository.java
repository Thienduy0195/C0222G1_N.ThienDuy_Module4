package com.duynguyen.furama.repository.contract;

import com.duynguyen.furama.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachRepository extends JpaRepository<AttachService,Integer> {
}
