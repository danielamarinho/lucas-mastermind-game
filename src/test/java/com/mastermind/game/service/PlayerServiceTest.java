package com.mastermind.game.service;

import com.mastermind.game.models.PlayerBodyModel;
import com.mastermind.game.models.repository.PlayerRegister;
import com.mastermind.game.repositories.PlayerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerServiceTest {

    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;


    @Before
    public void setUp() {
        initMocks(this);
        playerService = new PlayerService(playerRepository);
    }

    @Test
    public void shouldRecordNewCarOnDatabase() {
        ArgumentCaptor<PlayerRegister> argumentCaptor = ArgumentCaptor.forClass(PlayerRegister.class);

        PlayerRegister playerRegister = mock(PlayerRegister.class);

        when(playerRegister.getId()).thenReturn(1L);

        when(playerRepository.save(argumentCaptor.capture()))
                .thenReturn(playerRegister);

        PlayerBodyModel playerBodyModel = PlayerBodyModel
                .builder()
                .name("Joaquim")
                .build();

        ResponseEntity<String> responseEntity = playerService.registerNewPlayer(playerBodyModel);

        verify(playerRepository, times(1)).save(argumentCaptor.capture());

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).contains("id:1");

        assertThat(argumentCaptor.getValue().getName()).isEqualTo("Joaquim");
    }
}