package com.mastermind.game.models;

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
}
