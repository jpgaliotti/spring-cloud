package com.example.lab4adjective.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class AdjectiveController {

    private final Random random = new Random();

    @Value("${words}") String[] words;

    @GetMapping("/")
    public String getWord() {

        return words[random.nextInt(words.length)];
    }
}
