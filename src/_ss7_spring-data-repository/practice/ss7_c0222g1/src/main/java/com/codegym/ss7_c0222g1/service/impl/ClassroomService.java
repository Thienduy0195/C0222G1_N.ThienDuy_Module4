package com.codegym.ss7_c0222g1.service.impl;

import com.codegym.ss7_c0222g1.model.Classroom;
import com.codegym.ss7_c0222g1.repository.IClassroomRepository;
import com.codegym.ss7_c0222g1.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepository iClassroomRepository;
    @Override
    public List<Classroom> findAll() {
        return iClassroomRepository.findAll();
    }
}
