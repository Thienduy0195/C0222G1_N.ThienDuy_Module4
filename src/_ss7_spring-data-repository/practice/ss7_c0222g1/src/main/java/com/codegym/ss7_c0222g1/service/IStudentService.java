package com.codegym.ss7_c0222g1.service;

import com.codegym.ss7_c0222g1.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    List<Student> getAll();

    Page<Student> getAll(Pageable pageable);

    void save(Student student);
}
