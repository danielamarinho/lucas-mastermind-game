package com.mastermind.game.repositories;

import com.mastermind.game.models.repository.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Long> {
}
