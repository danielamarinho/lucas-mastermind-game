package com.mastermind.game.controller;

import com.mastermind.game.models.Game;
import com.mastermind.game.models.ListGame;
import com.mastermind.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public Game creatingGame(@RequestBody Game game) {
        return gameService.createNewGame(game);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListGame getGames() {
        return gameService.getCurrentGames();
    }
}
