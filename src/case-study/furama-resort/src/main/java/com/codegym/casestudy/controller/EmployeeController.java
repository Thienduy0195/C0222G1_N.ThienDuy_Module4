package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.employee_dto.EmployeeDto;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.service.IAppRoleService;
import com.codegym.casestudy.service.IAppUserService;
import com.codegym.casestudy.service.IUserRoleService;
import com.codegym.casestudy.service.interface_employee.IDivisionService;
import com.codegym.casestudy.service.interface_employee.IEducationDegreeService;
import com.codegym.casestudy.service.interface_employee.IEmployeeService;
import com.codegym.casestudy.service.interface_employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IAppRoleService iAppRoleService;
    @Autowired
    private IAppUserService iAppUserService;
    @Autowired
    private IUserRoleService iUserRoleService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @GetMapping()
    public String goEmployeePage(Model model,
                                 @RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "4") Integer pageSize,
                                 @RequestParam Optional<String> sort,
                                 @RequestParam Optional<String> dir,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<String> position,
                                 @RequestParam Optional<String> division,
                                 @RequestParam Optional<String> educationDegree) {
        Pageable pageable;
        String keywordName = name.orElse("");
        String positionKey = position.orElse("%");
        String divisionKey = division.orElse("%");
        String educationDegreeKey = educationDegree.orElse("%");
        String dirVal = dir.orElse("");
        String sortVal = sort.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if ("asc".equals(dirVal)) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }

        model.addAttribute("position", this.iPositionService.findAll());
        model.addAttribute("division", this.iDivisionService.findAll());
        model.addAttribute("education", this.iEducationDegreeService.findAll());
        model.addAttribute("employees", this.iEmployeeService.findAllEmployee(keywordName, divisionKey, positionKey, educationDegreeKey, pageable));
//        model.addAttribute("employees", this.iEmployeeService.findAllBy());
        model.addAttribute("keywordName", keywordName);
        model.addAttribute("positionKey", positionKey);
        model.addAttribute("divisionKey", divisionKey);
        model.addAttribute("educationDegreeKey", educationDegreeKey);
        model.addAttribute("sortVal", sortVal);
        model.addAttribute("dirVal", dirVal);
        return "employee/employee_list";
    }

    @GetMapping("/goCreate")
    public String goCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positions", this.iPositionService.findAll());
        model.addAttribute("divisions", this.iDivisionService.findAll());
        model.addAttribute("educations", this.iEducationDegreeService.findAll());
        return "employee/create_employee";
    }

    @PostMapping("/save")
    public String createEmployee(@ModelAttribute @Validated EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        this.iEmployeeService.checkExists(employeeDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", this.iPositionService.findAll());
            model.addAttribute("divisions", this.iDivisionService.findAll());
            model.addAttribute("educations", this.iEducationDegreeService.findAll());
            return "employee/create_employee";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        return "employee/detail_employee";
    }

    @GetMapping("edit")
    public String goEdit(@RequestParam Integer id, Model model) {
        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positions", this.iPositionService.findAll());
        model.addAttribute("divisions", this.iDivisionService.findAll());
        model.addAttribute("educations", this.iEducationDegreeService.findAll());
        return "employee/edit_employee";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        this.iEmployeeService.checkExists(employeeDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", this.iPositionService.findAll());
            model.addAttribute("divisions", this.iDivisionService.findAll());
            model.addAttribute("educations", this.iEducationDegreeService.findAll());
            return "employee/edit_employee";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, Model model) {
        this.iEmployeeService.softDelete(id);
        return "redirect:/employee";
    }

    @GetMapping("/delete_check")
    public String deleteCheck(@RequestParam("cid") Integer[] idCheck) {
        this.iEmployeeService.deleteCheck(idCheck);
        return "redirect:/employee";
    }
}
