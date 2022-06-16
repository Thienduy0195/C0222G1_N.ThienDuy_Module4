package com.emailEx.controller;

import com.emailEx.model.Email;
import com.emailEx.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmailController {

    @Autowired
    IEmailService emailService;

    @GetMapping("home")
    public String formToSubmit(Model model) {
        List<String> language = emailService.getLanguages();
        List<String> size = emailService.getSize();
        model.addAttribute("language", language);
        model.addAttribute("size", size);
        model.addAttribute("email", new Email());
        return "home";
    }

    @PostMapping("home/email")
    public String ShowEmailInfo(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("filter", email.getFilter());
        model.addAttribute("signature", email.getSignature());
        return "info";
    }

}
