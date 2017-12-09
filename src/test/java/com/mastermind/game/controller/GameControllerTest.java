package com.mastermind.game.controller;

import com.mastermind.game.models.Game;
import com.mastermind.game.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    @Mock
    private GameService gameService;

    @InjectMocks
    private GameController gameController;

    @Test
    public void shouldReturnANewGameCreate() {

        Game game = Game.builder().id(1L).playerId(1L).build();
        when(this.gameService.createNewGame(any(Game.class))).thenReturn(new Game(1L, 1L,1234));

        Game creatingGame = gameController.creatingGame(game);

        assertThat(creatingGame.getId()).isEqualTo(1L);
        assertThat(creatingGame.getPlayerId()).isEqualTo(1L);
        assertThat(creatingGame.getKey()).isEqualTo(1234);
    }
}
