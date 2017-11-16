package com.mastermind.game.controller;

import com.mastermind.game.models.PlayerBodyModel;
import com.mastermind.game.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class PlayerControllerTest {


    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @Before
    public void setUp() {
        initMocks(this);
        this.playerController = new PlayerController(playerService);
    }



    @Test
    public void shouldReturnSuccessWhenCreateANewPlayer() {

        PlayerBodyModel playerBodyModel = PlayerBodyModel.builder().name("Maria").build();

        ArgumentCaptor<PlayerBodyModel> argumentCaptor = ArgumentCaptor.forClass(PlayerBodyModel.class);

        when(this.playerService.registerNewPlayer(argumentCaptor.capture())).thenReturn(new ResponseEntity<>("{ id = 1}", HttpStatus.CREATED));

        ResponseEntity<String> responseEntity = this.playerController.creatingPlayer(playerBodyModel);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isEqualTo("{ id = 1}");


    }

}
