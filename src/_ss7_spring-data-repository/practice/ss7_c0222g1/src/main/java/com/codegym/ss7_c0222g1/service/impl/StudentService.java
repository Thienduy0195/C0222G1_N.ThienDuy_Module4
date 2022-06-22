package com.codegym.ss7_c0222g1.service.impl;

import com.codegym.ss7_c0222g1.model.Student;
import com.codegym.ss7_c0222g1.repository.IStudentRepository;
import com.codegym.ss7_c0222g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Override
    public List<Student> getAll() {
        return iStudentRepository.findAllStudent();
    }

    @Override
    public Page<Student> getAll(Pageable pageable) {
        return iStudentRepository.findAllStudent(pageable);
    }

    @Override
    public void save(Student student) {
        this.iStudentRepository.save(student);
    }
}
