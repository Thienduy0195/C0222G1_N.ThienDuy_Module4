package com.duynguyen.furama.service.emloyee.impl;

import com.duynguyen.furama.model.employee.Position;
import com.duynguyen.furama.repository.employee.IPositionRepository;
import com.duynguyen.furama.service.emloyee.IPositionService;
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
