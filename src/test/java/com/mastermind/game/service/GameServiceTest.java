package com.mastermind.game.service;

import com.mastermind.game.models.Game;
import com.mastermind.game.models.repository.GameEntity;
import com.mastermind.game.repositories.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    @Test
    public void shouldCreateNewGame(){
        Game requestGame = Game.builder().id(1L).playerId(1L).build();
        GameEntity gameSaved = new GameEntity(requestGame);

        when(gameRepository.save(any(GameEntity.class))).thenReturn(gameSaved);

        Game game = gameService.createNewGame(requestGame);

        assertThat(game).isEqualToComparingFieldByField(requestGame);
    }
}
