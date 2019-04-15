package com.example.lab4subject.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SubjectGen {

    private final Random random = new Random();

    @Value("${words}") String[] words;

    @GetMapping
    public @ResponseBody String getWord() {

        return words[random.nextInt(words.length)];
    }
}
