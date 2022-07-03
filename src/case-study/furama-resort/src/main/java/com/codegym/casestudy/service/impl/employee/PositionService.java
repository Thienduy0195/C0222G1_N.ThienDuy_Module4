package com.codegym.casestudy.service.impl.employee;

import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.repository.employee.IPositionRepository;
import com.codegym.casestudy.service.interface_employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
