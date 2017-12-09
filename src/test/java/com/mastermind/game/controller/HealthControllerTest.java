package com.mastermind.game.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthControllerTest {

    private HealthController healthControllerr;

    @Before
    public void setUp() {
        this.healthControllerr = new HealthController();
    }

    @Test
    public void shouldReturnHttpStatusOkWhenHealthIsUp() {
        ResponseEntity<String> httpStatus = this.healthControllerr.getHealth();
        assertThat(httpStatus.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
