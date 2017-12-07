package com.mastermind.game.repositories;

import com.mastermind.game.models.repository.PlayerEntity;
<<<<<<< HEAD
import com.mastermind.game.models.repository.PlayerRegister;
=======
>>>>>>> #19 [~lucasdornelas] Aply sugestions of code review
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
}
