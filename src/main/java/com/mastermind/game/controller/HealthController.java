package com.mastermind.game.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/healthcheck")
    public ResponseEntity<String> getHealth() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
