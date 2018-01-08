package com.mastermind.game.service;

import com.mastermind.game.models.Game;
import com.mastermind.game.models.ListGame;
import com.mastermind.game.models.ListGameEntity;
import com.mastermind.game.models.repository.GameEntity;
import com.mastermind.game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createNewGame(Game game) {

        return new Game(gameRepository.save(new GameEntity(game)));
    }

    public ListGame getCurrentGames() {

        return new ListGame(new ListGameEntity(gameRepository.findAll()));
    }
}
