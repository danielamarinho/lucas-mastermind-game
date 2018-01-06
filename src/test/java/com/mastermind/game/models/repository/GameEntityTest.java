package com.mastermind.game.models.repository;

import com.mastermind.game.models.Game;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameEntityTest {

    @Test
    public void shouldBuildGameEntityFromGama() throws Exception {

        Game game = new Game(1L, 2L);

        GameEntity gameEntity = new GameEntity(game);

        assertThat(gameEntity).isEqualToComparingFieldByField(game);
    }
}