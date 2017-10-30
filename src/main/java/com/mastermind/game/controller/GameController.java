package com.mastermind.game.controller;

import com.mastermind.game.health.HealthCheck;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/healthcheck", method = RequestMethod.GET)
    public ResponseEntity<String> getHealth() {
        HealthCheck healthCheck = new HealthCheck();
        Health health = healthCheck.health();

        return new ResponseEntity<>(new String().concat(health.getStatus().getCode()), HttpStatus.OK);
    }
}
