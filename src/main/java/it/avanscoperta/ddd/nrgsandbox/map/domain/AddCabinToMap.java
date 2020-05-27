package it.avanscoperta.ddd.nrgsandbox.map.domain;

import it.avanscoperta.ddd.nrgsandbox.network.domain.CabinId;
import it.avanscoperta.ddd.nrgsandbox.common.Coordinates;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Adds a Cabinet to the local map.
 * We need a Command only if the Map can actually reject the update.
 *
 */
public class AddCabinToMap {

    @TargetAggregateIdentifier
    private final MapId mapId;
    private final Coordinates coordinates;
    private final String label;
    private final CabinId cabinId;

    public AddCabinToMap(MapId mapId, Coordinates coordinates, String label, CabinId cabinId) {
        this.mapId = mapId;
        this.coordinates = coordinates;
        this.label = label;
        this.cabinId = cabinId;
    }


}
