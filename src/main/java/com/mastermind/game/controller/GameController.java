package com.mastermind.game.controller;

import com.mastermind.game.models.Game;
import com.mastermind.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/creatinggame", produces = MediaType.APPLICATION_JSON_VALUE)
    public Game creatingGame(Game game) {

        return gameService.createNewGame(game);
    }
}
