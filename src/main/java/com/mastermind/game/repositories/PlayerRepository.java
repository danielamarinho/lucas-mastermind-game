package com.mastermind.game.repositories;

import com.mastermind.game.models.repository.PlayerEntity;
import com.mastermind.game.models.repository.PlayerRegister;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
}
