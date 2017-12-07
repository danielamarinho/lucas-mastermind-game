package com.mastermind.game.service;

import com.mastermind.game.models.Player;
import com.mastermind.game.models.repository.PlayerEntity;
import com.mastermind.game.repositories.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Test
    public void shouldRecordNewCarOnDatabase() {
        //preparacao
        PlayerEntity savedPlayer = new PlayerEntity(1L, "Batata");
        Player requestPlayer = Player
                .builder()
                .name("Joaquim")
                .build();
        when(playerRepository.save(any(PlayerEntity.class))).thenReturn(savedPlayer);

        //acao
        Player playerCreated = playerService.registerNewPlayer(requestPlayer);

        //esperado
        assertThat(playerCreated.getId()).isEqualTo(1L);
        assertThat(playerCreated.getName()).contains("Batata");
    }
}