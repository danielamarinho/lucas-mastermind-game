package com.mastermind.game.models;

import com.mastermind.game.models.repository.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Player {

    private Long id;
    private String name;

    public Player(PlayerEntity playerEntity) {
        this.id = playerEntity.getId();
        this.name = playerEntity.getName();
    }

    public Player(String name) {
        this.name = name;
    }

}
