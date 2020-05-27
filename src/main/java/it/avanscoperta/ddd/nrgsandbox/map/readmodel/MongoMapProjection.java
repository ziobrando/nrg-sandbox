package it.avanscoperta.ddd.nrgsandbox.map.readmodel;

import it.avanscoperta.ddd.nrgsandbox.network.domain.events.CabinAddedToPatch;
import org.springframework.stereotype.Component;

/**
 * If the map is just a different view on the network, with no possibility for
 * rejecting commands, then we can treat it as a view and handle the required
 * translation in the projection.
 */
@Component
public class MongoMapProjection implements MapProjection {

    final
    MongoMapRepository repository;

    public MongoMapProjection(MongoMapRepository repository) {
        this.repository = repository;
    }

    /**
     * Writes on the local persistence in the appropriate format.
     * @param event the CabinAddedToPatch coming form the foreign Bounded Context
     */
    @Override
    public void on(CabinAddedToPatch event) {
        MapView view = new MapView(
                resolveItemId(event),
                event.getCoordinates(),
                event.getLabel(),
                ComponentType.CABINET
        );
        repository.save(view);
    }

    /**
     * Possibly a shortcut here. Need to investigate existing policies for the IDs
     *
     * @param event the CabinAddedToPatch that contains all the information.
     * @return a valid id for the local persistence.
     */
    private String resolveItemId(CabinAddedToPatch event) {
        return event.getCabinId().toString();
    }
}
