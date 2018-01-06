package com.mastermind.game.models.repository;

import com.mastermind.game.models.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "game_register", schema = "master_mind_game_schema")
@AllArgsConstructor
@NoArgsConstructor
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_register_id_seq")
    @SequenceGenerator(name = "game_register_id_seq",
            sequenceName = "master_mind_game_schema.game_register_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "player_register_id")
    private Long playerId;
    private int key;

    public GameEntity(Game game) {
     this.id = game.getId();
     this.playerId = game.getPlayerId();
     this.key = game.getKey();
    }

}

