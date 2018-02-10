package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Game {

    private Long id;
    private Long playerId;
    private int key;

    public Game(Long id, Long playerId) {
        this.id = id;
        this.playerId = playerId;
        this.key = generateKey();
    }

    public Game(GameEntity gameEntity) {
        this.id = gameEntity.getId();
        this.playerId = gameEntity.getPlayerId();
        this.key = gameEntity.getKey();
    }

    private int generateKey() {
        this.key = 1000 + (new Random()).nextInt(8999) ;
        return this.key;
    }
}
