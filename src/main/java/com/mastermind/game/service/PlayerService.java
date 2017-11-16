package com.mastermind.game.service;

import com.mastermind.game.models.PlayerBodyModel;
import com.mastermind.game.models.repository.PlayerRegister;
import com.mastermind.game.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ResponseEntity<String> registerNewPlayer(PlayerBodyModel playerBodyModel) {

        PlayerRegister playerRegister = new PlayerRegister(playerBodyModel.getName());

        PlayerRegister playerRegisterSave = playerRepository.save(playerRegister);

        return new ResponseEntity<>(new String()
                .concat("id:")
                .concat(playerRegisterSave.getId().toString()), HttpStatus.CREATED);
    }
}
