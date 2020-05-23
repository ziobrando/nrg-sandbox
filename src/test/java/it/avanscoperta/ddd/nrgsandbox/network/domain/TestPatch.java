package it.avanscoperta.ddd.nrgsandbox.network.domain;

import it.avanscoperta.ddd.nrgsandbox.common.Coordinates;
import it.avanscoperta.ddd.nrgsandbox.network.domain.commands.AddCabin;
import it.avanscoperta.ddd.nrgsandbox.network.domain.commands.CreatePatch;
import it.avanscoperta.ddd.nrgsandbox.network.domain.events.CabinAddedToPatch;
import it.avanscoperta.ddd.nrgsandbox.network.domain.events.PatchCreated;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class TestPatch {


    AggregateTestFixture<Patch> fixture = new AggregateTestFixture(Patch.class);
    private UUID patchId;
    private String name;
    private String author;
    private LocalDate date;
    private String goal;
    private CreatePatch createPatch;
    private PatchCreated patchCreated;

    @BeforeEach
    void setUp() {
        patchId = UUID.randomUUID();
        name = "Test Patch";
        author = "Peter Parker";
        date = LocalDate.now();
        goal = "Alimentare il mio frigo abusivo";

        createPatch = new CreatePatch(patchId, name, author, date, goal);
        patchCreated = new PatchCreated(patchId, name, author, date, goal);
    }

    @Test
    public void can_create_a_patch() {

        fixture.givenNoPriorActivity()
                .when(createPatch)
                .expectSuccessfulHandlerExecution()
                .expectEvents(patchCreated);

    }

    @Test
    public void can_add_a_cabin() {

        CabinId cabinId = CabinId.generate();
        Coordinates coordinates = new Coordinates(45.32, -38.45);
        String label = "Controllo Centrale";
        CabinType cabinType = CabinType.DISPATCHING; // Just a different typesafe information

        AddCabin addCabin = new AddCabin(patchId, cabinId, coordinates, label, cabinType);
        CabinAddedToPatch cabinAddedToPatch = new CabinAddedToPatch(patchId, cabinId, coordinates, label, cabinType);

        fixture.given(patchCreated)
                .when(addCabin)
                .expectSuccessfulHandlerExecution()
                .expectEvents(cabinAddedToPatch);
    }
}
