package com.github.gibsgibs.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    @GetMapping("api")
    public String getCharacterSummary(@RequestParam String name, String realm) {
        return String.format("{\"name\": \"%s\", \"realm\": \"%s\"}", name, realm);
    }
}
