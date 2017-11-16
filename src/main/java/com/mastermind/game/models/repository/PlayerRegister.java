package com.mastermind.game.models.repository;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "player_register", schema = "master_mind_game_schema")
public class PlayerRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_register_id_seq")
    @SequenceGenerator(name = "player_register_id_seq",
            sequenceName = "master_mind_game_schema.player_register_id_seq",
            allocationSize = 1)
    private Long id;
    private String name;

    public PlayerRegister(String name) {
        this.name = name;
    }

    public PlayerRegister() {
    }

    public PlayerRegister(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
