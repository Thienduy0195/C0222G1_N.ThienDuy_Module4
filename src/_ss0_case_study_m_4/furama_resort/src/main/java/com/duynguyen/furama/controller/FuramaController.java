package com.duynguyen.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuramaController {

    @RequestMapping("")
    public String homePage(){
        return "home/home";
    }
}
