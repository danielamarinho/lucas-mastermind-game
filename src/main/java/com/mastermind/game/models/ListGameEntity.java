package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ListGameEntity {

    private List<GameEntity> gameEntities;

    public ListGameEntity(Iterable<GameEntity> gameEntities) {
        this.gameEntities = (List<GameEntity>) gameEntities;
    }

    public ListGameEntity() {
        this.gameEntities = new ArrayList<>();
    }
}
