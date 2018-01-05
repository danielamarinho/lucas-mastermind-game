package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void shoulGenenateNewKey() {
        Game game = new Game(1L, 1L);

        int key = game.getKey();
        int sizeKey = (int) Math.log10(key)+1;

        assertThat(4).isEqualTo(sizeKey);
    }

    @Test
    public void shouldBuildGameEntityFromGame() throws Exception {

        GameEntity gameEntity = new GameEntity(1L, 1L, 1234);
        Game game = new Game(gameEntity);

        assertThat(game.getId()).isEqualTo(gameEntity.getId());
        assertThat(game.getPlayerId()).isEqualTo(gameEntity.getPlayerId());
        assertThat(game.getKey()).isEqualTo(gameEntity.getKey());
    }
}
