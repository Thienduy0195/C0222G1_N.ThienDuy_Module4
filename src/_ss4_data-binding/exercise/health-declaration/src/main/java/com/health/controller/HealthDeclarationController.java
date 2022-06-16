package com.health.controller;

import com.health.model.Health;
import com.health.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HealthDeclarationController {

    @Autowired
    private IHealthDeclarationService healthDeclarationService;


    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("years", healthDeclarationService.getYearList());
        model.addAttribute("genders", healthDeclarationService.getGenders());
        model.addAttribute("nations", healthDeclarationService.getNations());
        model.addAttribute("vehicles", healthDeclarationService.getVehicles());
        model.addAttribute("healthDeclaration", healthDeclarationService.getHealth());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Health healthDeclaration, Model model) {
        this.healthDeclarationService.save(healthDeclaration);
        model.addAttribute("healthDeclaration", healthDeclaration);
        return "save";
    }
}
