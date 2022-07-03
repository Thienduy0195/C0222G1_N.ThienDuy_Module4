package com.codegym.casestudy.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private Integer eduDegreeId;


    @Column(name = "education_degree_name")
    private String eduDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public EducationDegree(Integer eduDegreeId, String eduDegreeName) {
        this.eduDegreeId = eduDegreeId;
        this.eduDegreeName = eduDegreeName;
    }

    public EducationDegree() {
    }

    public Integer getEduDegreeId() {
        return eduDegreeId;
    }

    public void setEduDegreeId(Integer eduDegreeId) {
        this.eduDegreeId = eduDegreeId;
    }

    public String getEduDegreeName() {
        return eduDegreeName;
    }

    public void setEduDegreeName(String eduDegreeName) {
        this.eduDegreeName = eduDegreeName;
    }
}
