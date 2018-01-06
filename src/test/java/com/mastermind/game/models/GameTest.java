package com.mastermind.game.models;

import com.mastermind.game.models.repository.GameEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void shouldBuildListGameEntityFromListGame() throws Exception {

        List<GameEntity> gameEntities = new ArrayList<>();
        gameEntities.add(new GameEntity(1L, 1L, 1234));
        gameEntities.add(new GameEntity(2L, 2L, 4321));

        List<Game> games = new Game().builderListGame(gameEntities);

        assertThat(games.get(0).getId()).isEqualTo(gameEntities.get(0).getId());
        assertThat(games.get(0).getPlayerId()).isEqualTo(gameEntities.get(0).getPlayerId());
        assertThat(games.get(0).getKey()).isEqualTo(gameEntities.get(0).getKey());

        assertThat(games.get(1).getId()).isEqualTo(gameEntities.get(1).getId());
        assertThat(games.get(1).getPlayerId()).isEqualTo(gameEntities.get(1).getPlayerId());
        assertThat(games.get(1).getKey()).isEqualTo(gameEntities.get(1).getKey());
    }
}
