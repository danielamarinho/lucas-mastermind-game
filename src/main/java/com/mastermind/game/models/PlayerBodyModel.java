package com.mastermind.game.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import org.json.JSONObject;

@Getter
@Builder
public class PlayerBodyModel {

    private String name;

    public PlayerBodyModel(String name) {
        this.name = name;
    }

    public PlayerBodyModel() {
    }

    public JSONObject toJson() throws JsonProcessingException {
        return new JSONObject(new ObjectMapper().writeValueAsString(this));
    }
}
