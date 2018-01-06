package com.mastermind.game.models.repository;

import com.mastermind.game.models.Player;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerEntityTest {


    @Test
    public void shouldBuildPlayerFromPlayerEntity() throws Exception {

        Player player = new Player(1L,"Batata");
        PlayerEntity playerEntity = new PlayerEntity(player);

        assertThat(playerEntity).isEqualToComparingFieldByField(player);
    }
}