package com.codegym.controller;

import com.codegym.service.ITransferringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyTransferringController {
    @Autowired
    ITransferringService transferringMoney;

    @GetMapping
    public String goHomePage() {
        return "transferring-money";
    }

    @PostMapping(value = "/transfer")
    public String transfer(@RequestParam Double usd,
                           Model model) {
        if (usd == null) {
            usd = 0.0;
        }
        Double usdToVnd = transferringMoney.transferring(usd);
        model.addAttribute("usdToVnd", usdToVnd);
        model.addAttribute("usd", usd);
        return "transferring-money";
    }
}
