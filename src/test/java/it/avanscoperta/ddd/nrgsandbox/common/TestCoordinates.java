package it.avanscoperta.ddd.nrgsandbox.common;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCoordinates {

    @Test
    public void can_create_a_coordinate() {
        Coordinates coordinates = new Coordinates(45, 76);
        assertNotNull(coordinates);
    }

    @Test
    void can_use_negative_values() {
        Coordinates coordinates = new Coordinates(-34.65, -77.762);
        assertNotNull(coordinates);
    }

    @Test
    void cannot_exceed_positive_longitude_limit() {
        assertThrows(RuntimeException.class, () -> {
            Coordinates tooEast = new Coordinates(181, 45);
        });
    }

    @Test
    void cannot_exceed_negative_longitude_limit() {
        assertThrows(RuntimeException.class, () -> {
            Coordinates tooWest = new Coordinates(-180.05, 45);
        });
    }

    @Test
    void cannot_exceed_positive_latitude_limit() {
        assertThrows(RuntimeException.class, () -> {
            Coordinates tooNorth = new Coordinates(-42.80, 91);
        });
    }

    @Test
    void cannot_exceed_negative_latitude_limit() {
        assertThrows(RuntimeException.class, () -> {
            Coordinates tooSouth = new Coordinates(-42.80, -90.01);
        });
    }

}
