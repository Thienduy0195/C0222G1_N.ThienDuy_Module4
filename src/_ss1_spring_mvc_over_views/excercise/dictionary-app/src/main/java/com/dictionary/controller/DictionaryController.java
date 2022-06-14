package com.dictionary.controller;

import com.dictionary.service.DictionaryService;
import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {

    @Autowired
    IDictionaryService dictionary;

    @GetMapping
    public String dictionary() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String english,
                           Model model) {
        String vietnamese = dictionary.translate(english);
        model.addAttribute("english", english);
        model.addAttribute("vietnamese", vietnamese);
        return "result";
    }
}
