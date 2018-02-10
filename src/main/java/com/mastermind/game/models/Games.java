package com.mastermind.game.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class Games {

    private List<Game> games;


    public Games() {
        this.games = new ArrayList<>();
    }

    public Games(GamesEntity gamesEntity) {
        this.games = gamesEntity.getGameEntities().stream()
                .map(Game::new)
                .collect(Collectors.toList());
    }
}

