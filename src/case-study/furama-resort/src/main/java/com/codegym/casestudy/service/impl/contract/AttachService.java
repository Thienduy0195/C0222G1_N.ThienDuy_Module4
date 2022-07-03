package com.codegym.casestudy.service.impl.contract;

import com.codegym.casestudy.repository.contract.IAttachRepository;
import com.codegym.casestudy.service.interface_contract.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachService  implements IAttachService {
    @Autowired
    IAttachRepository attachRepository;

    @Override
    public List<com.codegym.casestudy.model.contract.AttachService> findAll() {
        return attachRepository.findAll();
    }
}
