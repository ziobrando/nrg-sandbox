package it.avanscoperta.ddd.nrgsandbox.map.readmodel;

import it.avanscoperta.ddd.nrgsandbox.common.Coordinates;
import org.springframework.data.annotation.Id;

public class MapView {

    @Id
    private String mapItemId;
    private Coordinates coordinates;
    private String label;
    private ComponentType componentType;

    public MapView(String mapItemId, Coordinates coordinates, String label, ComponentType componentType) {
        this.mapItemId = mapItemId;
        this.coordinates = coordinates;
        this.label = label;
        this.componentType = componentType;
    }
}
