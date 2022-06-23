package com.codegym.validate_form.controller;

import com.codegym.validate_form.model.User;
import com.codegym.validate_form.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/save")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/index";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("message", "Create user successfully!");
        return "redirect:/user";
    }
}
