package com.mastermind.game.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.json.JSONObject;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Player {

    private Long id;
    private String name;

    public JSONObject toJson() throws JsonProcessingException {
        return new JSONObject(new ObjectMapper().writeValueAsString(this));
    }
}
