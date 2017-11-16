package com.mastermind.game.controller;
import com.mastermind.game.models.Player;
import com.mastermind.game.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @Test
    public void shouldReturnSuccessWhenCreateANewPlayer() {

        Player player = Player.builder().name("Maria").build();

        when(this.playerService.registerNewPlayer(any(Player.class))).thenReturn(new Player(1L,"Maria"));

        Player playerCreated = this.playerController.creatingPlayer(player);

        assertThat(playerCreated.getId()).isEqualTo(1L);
        assertThat(playerCreated.getName()).isEqualTo("Maria");
    }

}
