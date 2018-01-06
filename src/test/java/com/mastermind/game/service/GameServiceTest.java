package com.mastermind.game.service;

import com.mastermind.game.models.Game;
import com.mastermind.game.models.repository.GameEntity;
import com.mastermind.game.repositories.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void shouldGetCurrentGames() throws Exception {

        Game gameOne = new Game(1L, 1L, 1234);
        Game gameTwo = new Game(2L, 2L, 4321);

        List<GameEntity> gameEntities = new ArrayList<>();
        gameEntities.add(new GameEntity(gameOne));
        gameEntities.add(new GameEntity(gameTwo));

        when(gameRepository.findAll()).thenReturn(gameEntities);

        List<Game> games = gameService.getCurrentGames();

        assertThat(games.get(0)).isEqualToComparingFieldByField(gameOne);
        assertThat(games.get(1)).isEqualToComparingFieldByField(gameTwo);
    }
}
