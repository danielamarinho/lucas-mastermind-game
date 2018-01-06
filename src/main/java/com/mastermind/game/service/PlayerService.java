package com.mastermind.game.service;

import com.mastermind.game.models.Player;
import com.mastermind.game.models.repository.PlayerEntity;
import com.mastermind.game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player registerNewPlayer(Player player) {

        PlayerEntity playerEntity = playerRepository.save(new PlayerEntity(player));

        return new Player(playerEntity);
    }
}
