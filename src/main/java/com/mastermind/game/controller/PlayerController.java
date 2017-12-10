package com.mastermind.game.controller;

import com.mastermind.game.models.Player;
import com.mastermind.game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {

        this.playerService = playerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/creatingplayer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Player creatingPlayer(@RequestBody Player player) {

        return playerService.registerNewPlayer(player);
    }
}
