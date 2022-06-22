package com.codegym.ss7_c0222g1.repository;

import com.codegym.ss7_c0222g1.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IStudentRepository extends JpaRepository<Student, Integer> {

//    Các vấn đề thay đổi dữ liệu thì dùng Annotation bên dưới và @Transactional
//    @Modifying

    @Query(value = "select * from student where name_student like :name",nativeQuery = true)
    List<Student> findAllByName(@Param("name") String name);

    @Query(value = "select * from student",nativeQuery = true)
    List<Student> findAllStudent();

    @Query(value = "select * from student",nativeQuery = true)
    Page<Student> findAllStudent(Pageable pageable);

}
