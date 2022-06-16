package com.emailEx.service.impl;

import com.emailEx.service.IEmailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Override
    public List<String> getLanguages() {
        List<String> languageList = new ArrayList<>();
        languageList.add("Vietnamese");
        languageList.add("English");
        languageList.add("Japanese");
        languageList.add("Chinese");
        return languageList;
    }

    @Override
    public List<String> getSize() {
        List<String> sizeList = new ArrayList<>();
        sizeList.add("5");
        sizeList.add("10");
        sizeList.add("15");
        sizeList.add("25");
        sizeList.add("50");
        sizeList.add("100");
        return sizeList;
    }
}
