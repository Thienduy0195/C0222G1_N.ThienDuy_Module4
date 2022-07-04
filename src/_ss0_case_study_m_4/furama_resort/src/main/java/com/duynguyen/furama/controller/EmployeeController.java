package com.duynguyen.furama.controller;

import com.duynguyen.furama.dto.employee_dto.EmployeeDto;
import com.duynguyen.furama.model.employee.Employee;
import com.duynguyen.furama.service.emloyee.IDivisionService;
import com.duynguyen.furama.service.emloyee.IEducationDegreeService;
import com.duynguyen.furama.service.emloyee.IEmployeeService;
import com.duynguyen.furama.service.emloyee.IPositionService;
import com.duynguyen.furama.service.user.IAppRoleService;
import com.duynguyen.furama.service.user.IAppUserService;
import com.duynguyen.furama.service.user.IUserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String showList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Sort sort = Sort.by("customer").ascending();
        Page<Employee> employeeList = iEmployeeService.findAllPageable(PageRequest.of(page, 10));
        model.addAttribute("employee", new Employee());
        model.addAttribute("positionList", this.iPositionService.findAll());
        model.addAttribute("divisionList", this.iDivisionService.findAll());
        model.addAttribute("educationList", this.iEducationDegreeService.findAll());
        model.addAttribute("employeeList", employeeList);
        return "employee/employee-list";
    }


    @GetMapping("/goCreate")
    public String goCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positions", this.iPositionService.findAll());
        model.addAttribute("divisions", this.iDivisionService.findAll());
        model.addAttribute("educations", this.iEducationDegreeService.findAll());
        return "employee/create-employee";
    }

    @PostMapping("/save")
    public String createEmployee(@ModelAttribute @Validated EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        this.iEmployeeService.checkExists(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positions", this.iPositionService.findAll());
            model.addAttribute("divisions", this.iDivisionService.findAll());
            model.addAttribute("educations", this.iEducationDegreeService.findAll());
            return "employee/create-employee";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            return "redirect:/employee";
        }
    }

//    @GetMapping("/detail")
//    public String goDetail(@RequestParam Integer id, Model model) {
//        Employee employee = this.iEmployeeService.findById(id);
//        EmployeeDto employeeDto = new EmployeeDto();
//        BeanUtils.copyProperties(employee, employeeDto);
//        model.addAttribute("employeeDto", employeeDto);
//        return "employee/detail-employee";
//    }

    @GetMapping("/edit/{id}")
    public String goEdit(@PathVariable Integer id, Model model) {
        Employee employee = this.iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positionList", this.iPositionService.findAll());
        model.addAttribute("divisionList", this.iDivisionService.findAll());
        model.addAttribute("educationList", this.iEducationDegreeService.findAll());
        return "employee/update-employee";
    }

//    @PostMapping("/update")
//    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,
//                         BindingResult bindingResult,
//                         Model model) {
//        new EmployeeDto().validate(employeeDto, bindingResult);
//        this.iEmployeeService.checkExists(employeeDto, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("positionList", this.iPositionService.findAll());
//            model.addAttribute("divisionList", this.iDivisionService.findAll());
//            model.addAttribute("educationList", this.iEducationDegreeService.findAll());
//            return "employee/update-employee";
//        } else {
//            Employee employee = new Employee();
//            BeanUtils.copyProperties(employeeDto, employee);
//            this.iEmployeeService.save(employee);
//            return "redirect:/employee";
//        }
//    }

//    @PostMapping("/update")
//    public String update() {
//            return "redirect:/employee";
//    }

        @PostMapping("/update")
    public String update(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        this.iEmployeeService.checkExists(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("positionList", this.iPositionService.findAll());
            model.addAttribute("divisionList", this.iDivisionService.findAll());
            model.addAttribute("educationList", this.iEducationDegreeService.findAll());
            return "employee/update-employee";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        this.iEmployeeService.softDelete(id);
        return "redirect:/employee";
    }

    @GetMapping("/delete_check")
    public String deleteCheck(@RequestParam("cid") Integer[] idCheck) {
        this.iEmployeeService.deleteCheck(idCheck);
        return "redirect:/employee";
    }
}
