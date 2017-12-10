package com.mastermind.game.service;

import com.mastermind.game.models.Game;
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

        GameEntity gameEntity = gameRepository.save(new GameEntity(game.getPlayerId(), game.generateKey()));

        return new Game(gameEntity.getId(), gameEntity.getPlayerId(), gameEntity.getKey());
    }
}
