package com.mastermind.game.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Game {

    private Long id;
    private Long playerId;
    private int key;

    public Game(Long id, Long playerId) {
        this.id = id;
        this.playerId = playerId;
        this.key = generateKey();
    }

    private int generateKey() {
        this.key = 1000 + (new Random()).nextInt(8999) ;
        return this.key;
    }
}
