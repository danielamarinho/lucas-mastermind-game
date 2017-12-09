package com.mastermind.game.models.repository;

import lombok.Getter;

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

    public GameEntity(Long id, Long playerId, int key) {
        this.id = id;
        this.playerId = playerId;
        this.key = key;
    }

    public GameEntity(Long id, Long playerId) {
        this.id = id;
        this.playerId = playerId;
    }
}

