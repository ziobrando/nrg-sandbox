package it.avanscoperta.ddd.nrgsandbox.network.domain;

import java.util.UUID;

public class CabinId {
    private final String cabinId;

    public CabinId(String toString) {
        this.cabinId = toString;
    }

    public static CabinId generate() {
        return new CabinId(UUID.randomUUID().toString());
    }
}
