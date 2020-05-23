package it.avanscoperta.ddd.nrgsandbox.network.domain.commands;

import it.avanscoperta.ddd.nrgsandbox.network.domain.CabinId;
import it.avanscoperta.ddd.nrgsandbox.network.domain.CabinType;
import it.avanscoperta.ddd.nrgsandbox.common.Coordinates;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class AddCabin {
    @TargetAggregateIdentifier
    private final UUID patchId;
    private final CabinId cabinId;
    private final Coordinates coordinates;
    private final String label;
    private final CabinType cabinType;

    public AddCabin(UUID patchId, CabinId cabinId, Coordinates coordinates, String label, CabinType cabinType) {
        this.patchId = patchId;
        this.cabinId = cabinId;
        this.coordinates = coordinates;
        this.label = label;
        this.cabinType = cabinType;
    }

    public UUID getPatchId() {
        return patchId;
    }

    public CabinId getCabinId() {
        return cabinId;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getLabel() {
        return label;
    }

    public CabinType getCabinType() {
        return cabinType;
    }
}
