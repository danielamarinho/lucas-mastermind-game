package com.mastermind.game.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mastermind.game.models.repository.PlayerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.JSONObject;

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

    public JSONObject toJson() throws JsonProcessingException {
        return new JSONObject(new ObjectMapper().writeValueAsString(this));
    }
}
