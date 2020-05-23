package it.avanscoperta.ddd.nrgsandbox.common;

/**
 * Domain Specific Value Object, with a whole lot of possibilities for improvement.
 */
public class Coordinates {

    private final double longitude;
    private final double latitude;

    public Coordinates(double longitude, double latitude) {
        if (longitude > 180) throw new IllegalArgumentException("longitude too big");
        if (longitude < -180) throw new IllegalArgumentException("longitude too big");
        if (latitude > 90) throw new IllegalArgumentException("latitude too big");
        if (latitude < -90) throw new IllegalArgumentException("latitude too big");

        this.longitude = longitude;
        this.latitude = latitude;
    }
}
