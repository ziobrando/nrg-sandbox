package it.avanscoperta.ddd.nrgsandbox.map.readmodel;


import it.avanscoperta.ddd.nrgsandbox.network.domain.events.CabinAddedToPatch;

/**
 * Common interface for projections on the map domain,
 * just in case we're going for multiple specialized outputs.
 */
public interface MapProjection {


    void on(CabinAddedToPatch event);
}
