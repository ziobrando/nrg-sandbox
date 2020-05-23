package it.avanscoperta.ddd.nrgsandbox.map.domain;


// Dependency on a plausible common library
import it.avanscoperta.ddd.nrgsandbox.common.Coordinates;

// Dependency on the events, that could be easily be moved on a common space.
import it.avanscoperta.ddd.nrgsandbox.network.domain.events.CabinAddedToPatch;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Do we need a saga for this?
 * I don't know the whole set of requirements, but maybe this implementation
 * is overkill compared to more lightweight alternatives.
 *
 * We might need a saga if we have to coordinate possible failures of the downstream
 * component, and reflect this action somewhere else.
 */
@Saga
public class MapUpdatePolicy {
    private final static MapId THE_MAP = new MapId("1");

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private transient CommandGateway commandGateway;

    public MapUpdatePolicy() {
        logger.debug(this.getClass().toString() + " has been initialized.");
    }

    /**
     * Whenever a Cabin is added to a given Patch, we make sure that the corresponding map
     * is updated with the cabin data.
     *
     * @param event
     */
    @SagaEventHandler(associationProperty = "patchId")
    @StartSaga
    public void on(CabinAddedToPatch event) {
        MapId mapId = resolve(event.getCoordinates());
        AddCabinToMap addCabinToMap = new AddCabinToMap(
                mapId,
                event.getCoordinates(),
                event.getLabel(),
                event.getCabinId());
        commandGateway.send(addCabinToMap);
    }

    private MapId resolve(Coordinates coordinates) {
        return THE_MAP;
    }

}
