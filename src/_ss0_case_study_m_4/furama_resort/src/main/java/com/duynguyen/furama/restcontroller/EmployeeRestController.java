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

import java.util.ArrayList;
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


    @GetMapping("/list")
    public ResponseEntity<Iterable<Employee>> showList() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.findById(id);
        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,  HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.findById(id);
        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.delete(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<List<Employee>> editEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        List<Employee> newList = new ArrayList<>();
        for (int j = 0; j <10 ; j++) {
            if (j==employeeService.findAll().size()){
                break;
            }
            newList.add(employeeService.findAll().get(j));
        }
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<List<Employee>> createEmployee(@RequestBody Employee employee) {
        employee.setId(null);
        employeeService.save(employee);
        List<Employee> newList = new ArrayList<>();
        for (int j = 0; j <10 ; j++) {
            if (j==employeeService.findAll().size()){
                break;
            }
            newList.add(employeeService.findAll().get(j));
        }
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }
}
