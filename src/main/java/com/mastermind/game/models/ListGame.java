package com.mastermind.game.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class ListGame {

    private List<Game> games;


    public ListGame() {
        this.games = new ArrayList<>();
    }

    public ListGame(ListGameEntity listGameEntity) {
        this.games = listGameEntity.getGameEntities().stream().map(Game::new).collect(Collectors.toList());
    }
}

