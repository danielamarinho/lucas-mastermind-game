package com.mastermind.game.models.repository;

import com.mastermind.game.models.Player;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "player_register", schema = "master_mind_game_schema")
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_register_id_seq")
    @SequenceGenerator(name = "player_register_id_seq",
            sequenceName = "master_mind_game_schema.player_register_id_seq",
            allocationSize = 1)
    private Long id;
    private String name;

    public PlayerEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PlayerEntity(Player player) {
        this.id = player.getId();
        this.name = player.getName();
    }
}
