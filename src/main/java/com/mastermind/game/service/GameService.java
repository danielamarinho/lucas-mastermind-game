package com.mastermind.game.service;

import com.mastermind.game.models.Game;
import com.mastermind.game.models.repository.GameEntity;
import com.mastermind.game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Game> getCurrentGames() {

        return new Game()
                .builderListGame((List<GameEntity>) gameRepository.findAll());
    }
}
