package com.mastermind.game.controller;

import com.mastermind.game.models.Game;
import com.mastermind.game.models.ListGame;
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

        Game game = new Game(1L,1L);
        when(this.gameService.createNewGame(any(Game.class))).thenReturn(new Game(1L, 1L,1234));

        Game creatingGame = gameController.creatingGame(game);

        assertThat(creatingGame.getId()).isEqualTo(1L);
        assertThat(creatingGame.getPlayerId()).isEqualTo(1L);
        assertThat(creatingGame.getKey()).isEqualTo(1234);
    }

    @Test
    public void shouldReturnACurrentGames() throws Exception {

        ListGame listGame = new ListGame();
        listGame.getGames().add(new Game(1L, 1L, 1234));
        listGame.getGames().add(new Game(2L, 2L, 4321));

        when(this.gameService.getCurrentGames()).thenReturn(listGame);

        ListGame currentGames = gameController.getGames();

        assertThat(currentGames.getGames().get(0)).isEqualToComparingFieldByField(listGame.getGames().get(0));
        assertThat(currentGames.getGames().get(1)).isEqualToComparingFieldByField(listGame.getGames().get(1));
    }
}
