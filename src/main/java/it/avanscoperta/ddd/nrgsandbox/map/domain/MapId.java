package it.avanscoperta.ddd.nrgsandbox.map.domain;

import java.util.Objects;

public class MapId {

    private final String id;

    public MapId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapId mapId = (MapId) o;
        return Objects.equals(id, mapId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
