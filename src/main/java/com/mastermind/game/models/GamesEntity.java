package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GamesEntity {

    private List<GameEntity> gameEntities;

    public GamesEntity(Iterable<GameEntity> gameEntities) {
        this.gameEntities = (List<GameEntity>) gameEntities;
    }

    public GamesEntity() {
        this.gameEntities = new ArrayList<>();
    }
}
