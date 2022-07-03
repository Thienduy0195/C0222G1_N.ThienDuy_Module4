package com.codegym.casestudy.service.impl.employee;

import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.repository.employee.IEducationDegreeRepository;
import com.codegym.casestudy.service.interface_employee.IEducationDegreeService;
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
