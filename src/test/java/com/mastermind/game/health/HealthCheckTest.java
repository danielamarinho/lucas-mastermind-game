package com.mastermind.game.health;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.actuate.health.Health;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HealthCheckTest {

    private HealthCheck healthCheck;

    @Before
    public void setUp() {
        this.healthCheck = new HealthCheck();
    }

    @Test
    public void shouldReturnHealthUpWhenNotCaptureError() {
        Health health = this.healthCheck.health();
        assertThat(health.getStatus().getCode(), is("UP"));
    }
}