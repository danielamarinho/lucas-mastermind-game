package com.mastermind.game.models;

import com.mastermind.game.models.repository.PlayerEntity;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void shouldBuildPlayerFromPlayerEntity() throws Exception {

        PlayerEntity playerEntity = new PlayerEntity(1L, "Batata");
        Player player = new Player(playerEntity);

        assertThat(player).isEqualToComparingFieldByField(playerEntity);
    }
}