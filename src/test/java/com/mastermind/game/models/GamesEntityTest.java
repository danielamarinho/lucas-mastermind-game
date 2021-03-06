package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GamesEntityTest {

    @Test
    public void shouldBuildListGameEntityFromListGame() throws Exception {

        List<GameEntity> gameEntities = new ArrayList<>();
        gameEntities.add(new GameEntity(1L, 1L, 1234));
        gameEntities.add(new GameEntity(2L, 2L, 4321));

        GamesEntity gamesEntity = new GamesEntity(gameEntities);

        assertThat(gamesEntity.getGameEntities().get(0)).isEqualToComparingFieldByField(gameEntities.get(0));
        assertThat(gamesEntity.getGameEntities().get(1)).isEqualToComparingFieldByField(gameEntities.get(1));
    }

}