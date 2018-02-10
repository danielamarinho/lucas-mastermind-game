package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GamesTest {


    @Test
    public void shouldBuildListGameEntityFromListGame() throws Exception {

        GamesEntity gamesEntity = new GamesEntity();
        gamesEntity.getGameEntities().add(new GameEntity(1L, 1L, 1234));
        gamesEntity.getGameEntities().add(new GameEntity(2L, 2L, 4321));

        Games games = new Games(gamesEntity);

        assertThat(games.getGames().get(0)).isEqualToComparingFieldByField(gamesEntity.getGameEntities().get(0));
        assertThat(games.getGames().get(1)).isEqualToComparingFieldByField(gamesEntity.getGameEntities().get(1));
    }
}