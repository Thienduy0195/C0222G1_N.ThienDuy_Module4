package com.duynguyen.furama.service.emloyee.impl;

import com.duynguyen.furama.model.employee.EducationDegree;
import com.duynguyen.furama.repository.employee.IEducationDegreeRepository;
import com.duynguyen.furama.service.emloyee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EducationService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
