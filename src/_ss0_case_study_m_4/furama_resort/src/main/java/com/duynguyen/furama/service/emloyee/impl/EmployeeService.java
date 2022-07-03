package com.duynguyen.furama.service.emloyee.impl;

import com.duynguyen.furama.dto.employee_dto.EmployeeDto;
import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.model.user.Role;
import com.duynguyen.furama.model.user.User;
import com.duynguyen.furama.repository.employee.IEmployeeRepository;
import com.duynguyen.furama.repository.user.IUserRepository;
import com.duynguyen.furama.service.emloyee.IEmployeeService;
import com.duynguyen.furama.service.user.IAppRoleService;
import com.duynguyen.furama.service.user.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IUserRepository appUserRepository;
    @Autowired
    private IAppRoleService iAppRoleService;
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllPageable(Pageable pageable) {
        return iEmployeeRepository.findAllPageable(pageable);
    }

    @Override
    public void save(Employee employee) {
        // goi cac phuong thuc lien quan toi dang ky user
        // dang ky user cho employee
//        AppUser appUser = this.appUserRepository.findByUsername(employee.getEmail());
//        if(appUser == null){
        if(employee.getId() == null){
            User employeeUser = new User();
            this.iUserRoleService.saveUser(employee, employeeUser);
            Role userRole = this.iAppRoleService.findRole(1);
            Role adminRole = this.iAppRoleService.findRole(2);
            this.iUserRoleService.saveUserRole(employee, employeeUser, userRole, adminRole);
        }
            employee.setStatus(1);
            this.iEmployeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        this.iEmployeeRepository.delete(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return this.iEmployeeRepository.findById(id).get();
    }

    @Override
    public void softDelete(Integer id) {
        this.iEmployeeRepository.softDelete(id);
    }

    @Override
    public void deleteCheck(Integer[] idCheck) {
        this.iEmployeeRepository.deleteCheck(Arrays.asList(idCheck));
    }


    @Override
    public void checkExists(EmployeeDto employeeDto, BindingResult bindingResult) {

        Employee existsEmail = this.iEmployeeRepository.findFirstByEmail(employeeDto.getEmail());

        Employee existsPhone = this.iEmployeeRepository.findFirstByPhone(employeeDto.getPhone());

        Employee existsIdCard = this.iEmployeeRepository.findFirstByIdCard(employeeDto.getIdCard());

        if (employeeDto.getId() == null) {

            if (!"".equals(employeeDto.getPhone())) {
                if (existsPhone != null) {
                    bindingResult.rejectValue("phone", "phone.duplicate", "errors");
                }
            }

            if (!"".equals(employeeDto.getEmail())) {
                if (existsEmail != null) {
                    bindingResult.rejectValue("email", "email.duplicate", "errors");
                }
            }

            if (!"".equals(employeeDto.getIdCard())) {
                if (existsIdCard != null) {
                    bindingResult.rejectValue("idCard", "id.card.duplicate", "errors");
                }
            }
        } else {
            if (existsPhone != null) {
                if (!existsPhone.getId().equals(employeeDto.getId())) {
                    bindingResult.rejectValue("phone", "phone.duplicate", "errors");
                }
            }

            if (existsEmail != null) {
                if (!existsEmail.getId().equals(employeeDto.getId())) {
                    bindingResult.rejectValue("email", "email.duplicate", "errors");
                }
            }

            if (existsIdCard != null) {
                if (!existsIdCard.getId().equals(employeeDto.getId())) {
                    bindingResult.rejectValue("idCard", "id.card.duplicate", "errors");
                }
            }
        }
    }
}
