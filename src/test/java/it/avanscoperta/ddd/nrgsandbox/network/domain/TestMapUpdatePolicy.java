package it.avanscoperta.ddd.nrgsandbox.network.domain;

import it.avanscoperta.ddd.nrgsandbox.common.Coordinates;
import it.avanscoperta.ddd.nrgsandbox.map.domain.AddCabinToMap;
import it.avanscoperta.ddd.nrgsandbox.map.domain.MapId;
import it.avanscoperta.ddd.nrgsandbox.map.domain.MapUpdatePolicy;
import it.avanscoperta.ddd.nrgsandbox.network.domain.events.CabinAddedToPatch;
import org.axonframework.test.saga.FixtureConfiguration;
import org.axonframework.test.saga.SagaTestFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class TestMapUpdatePolicy {


    FixtureConfiguration fixture = new SagaTestFixture<MapUpdatePolicy>(MapUpdatePolicy.class);
    private UUID patchId;
    private CabinId cabinId;
    private Coordinates coordinates;
    private String label;
    private CabinType cabinType;

    @BeforeEach
    void setUp() {
        patchId = UUID.randomUUID();
        cabinId = CabinId.generate();
        coordinates = new Coordinates(21.44, 33.5633);
        label = "la voglio vedere";
        cabinType = CabinType.DISPATCHING;
    }

    @Test
    public void adding_a_cabin_adds_a_point_to_the_map() {

        CabinAddedToPatch cabinAddedToPatch = new CabinAddedToPatch(patchId, cabinId, coordinates, label, cabinType);

        MapId mapId = new MapId("1"); // FIXME: or i get it from the command or we resolve it.

        AddCabinToMap addCabinToMap = new AddCabinToMap(mapId, coordinates, label, cabinId);

        fixture.givenNoPriorActivity()
                .whenPublishingA(cabinAddedToPatch)
                .expectDispatchedCommands(addCabinToMap);


    }
}
