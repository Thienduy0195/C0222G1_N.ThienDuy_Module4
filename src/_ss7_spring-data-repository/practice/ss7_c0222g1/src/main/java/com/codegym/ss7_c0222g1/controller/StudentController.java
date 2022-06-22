package com.codegym.ss7_c0222g1.controller;

import com.codegym.ss7_c0222g1.dto.StudentAccountDTO;
import com.codegym.ss7_c0222g1.model.Account;
import com.codegym.ss7_c0222g1.model.Student;
import com.codegym.ss7_c0222g1.service.IClassroomService;
import com.codegym.ss7_c0222g1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

    @Autowired
    private IClassroomService iClassroomService;

//    @RequestMapping(method = RequestMethod.GET, value = "/list")
//    @GetMapping(value = "/list")
//    public String getAllStudent(Model model) {
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
//        return "list";
//    }

    @GetMapping(value = "/list")
    public String showListStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("point").ascending().and(Sort.by("name_student"));
        Page<Student> list = iStudentService.getAll(PageRequest.of(page, 2, sort));
        model.addAttribute("listStudent", list);
        return "list";
    }

    @GetMapping("/create")
    public String movePageCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClass", iClassroomService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student,
                                RedirectAttributes redirectAttributes) {
//        Student student = new Student(studentAccountDTO.getCodeStudent(), studentAccountDTO.getNameStudent(),
//                studentAccountDTO.getPoint(), studentAccountDTO.getGender());
//        Account account = new Account(studentAccountDTO.getUsername(), studentAccountDTO.getPassword());

        iStudentService.save(student);
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/detail/{codeStudent}")
    public String moveDetail(@PathVariable(value = "codeStudent", required = false) Integer codeStudent) {
        System.out.println(codeStudent);
        return "detail";
    }

}
