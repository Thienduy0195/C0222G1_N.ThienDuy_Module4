package com.duynguyen.furama.restcontroller;

import com.duynguyen.furama.model.customer.Customer;
import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.model.employee.Position;
import com.duynguyen.furama.model.service.Service;
import com.duynguyen.furama.service.emloyee.IDivisionService;
import com.duynguyen.furama.service.emloyee.IEducationDegreeService;
import com.duynguyen.furama.service.emloyee.IEmployeeService;
import com.duynguyen.furama.service.emloyee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    IPositionService positionService;

    @Autowired
    IDivisionService divisionService;

    @Autowired
    IEducationDegreeService degreeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.findById(id);
        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,  HttpStatus.OK);
    }

    @GetMapping("/get-position")
    public ResponseEntity<?> getPosition(){
        List<Position> positionList = positionService.findAll();
        return new ResponseEntity<>(positionList,  HttpStatus.OK);
    }

//    @GetMapping("/get-division")
//
//
//    @GetMapping("/get-education")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.findById(id);
        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.delete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
