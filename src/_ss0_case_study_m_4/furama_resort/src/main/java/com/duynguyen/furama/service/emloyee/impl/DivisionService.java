package com.duynguyen.furama.service.emloyee.impl;

import com.duynguyen.furama.model.employee.Division;
import com.duynguyen.furama.repository.employee.IDivisionRepository;
import com.duynguyen.furama.service.emloyee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
