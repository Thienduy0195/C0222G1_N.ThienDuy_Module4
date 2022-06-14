package com.dictionary.controller;

import com.dictionary.service.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    Dictionary dictionary = new Dictionary();
    @GetMapping
    public String dictionary(){
    return "index";
    }

    @PostMapping("/translate")
    public String transfer(@RequestParam String english,
                           Model model) {
        String vietnamese = dictionary.getWord(english);
        model.addAttribute("english", english);
        model.addAttribute("vietnamese", vietnamese);
        return "result";
    }
}
