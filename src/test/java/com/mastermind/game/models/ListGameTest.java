package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ListGameTest {


    @Test
    public void shouldBuildListGameEntityFromListGame() throws Exception {

        ListGameEntity listGameEntity = new ListGameEntity();
        listGameEntity.getGameEntities().add(new GameEntity(1L, 1L, 1234));
        listGameEntity.getGameEntities().add(new GameEntity(2L, 2L, 4321));

        ListGame games = new ListGame(listGameEntity);

        assertThat(games.getGames().get(0)).isEqualToComparingFieldByField(listGameEntity.getGameEntities().get(0));
        assertThat(games.getGames().get(1)).isEqualToComparingFieldByField(listGameEntity.getGameEntities().get(1));
    }
}