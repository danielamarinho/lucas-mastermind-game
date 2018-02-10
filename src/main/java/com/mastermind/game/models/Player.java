package com.mastermind.game.models;

import com.mastermind.game.models.repository.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {

    private Long id;
    private String name;

    public Player(PlayerEntity playerEntity) {
        this.id = playerEntity.getId();
        this.name = playerEntity.getName();
    }

    public Player(String name) {
        this.name = name;
    }

}
