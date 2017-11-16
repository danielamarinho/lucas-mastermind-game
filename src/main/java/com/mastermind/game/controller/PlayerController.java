package com.mastermind.game.controller;

import com.mastermind.game.models.PlayerBodyModel;
import com.mastermind.game.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping(value = "/creatingplayer")
    public ResponseEntity<String> creatingPlayer(PlayerBodyModel playerBodyModel) {

        return playerService.registerNewPlayer(playerBodyModel);
    }
}
