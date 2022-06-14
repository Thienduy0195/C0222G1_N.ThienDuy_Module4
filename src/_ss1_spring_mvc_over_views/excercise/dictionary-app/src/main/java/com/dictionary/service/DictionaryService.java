package com.dictionary.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static final Map<String, String> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put("hello", "xin chào");
        dictionaryMap.put("name", "tên");
        dictionaryMap.put("programmer", "lập trình viên");
        dictionaryMap.put("thank", "cảm ơn");
    }

    @Override
    public String translate(String word) {
        String vietnamese = dictionaryMap.get(word);
        if (vietnamese == null) {
            vietnamese = "not found!";
        }
        return vietnamese;
    }
}
