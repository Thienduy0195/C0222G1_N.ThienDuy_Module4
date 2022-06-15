package com.calculator.controller;

import com.calculator.services.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/")
    public String loadIndex() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("firstOperand") float firstOperand,
                            @RequestParam("secondOperand") float secondOperand,
                            @RequestParam("operator") Character operator,
                            Model model) {

        float result = calculatorService.calculate(firstOperand, secondOperand, operator);
        model.addAttribute("result", "RESULT: " + result);
        return "index";
    }

}
