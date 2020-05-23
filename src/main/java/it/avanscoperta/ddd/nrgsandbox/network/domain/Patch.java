package it.avanscoperta.ddd.nrgsandbox.network.domain;

import it.avanscoperta.ddd.nrgsandbox.network.domain.commands.AddCabin;
import it.avanscoperta.ddd.nrgsandbox.network.domain.commands.CreatePatch;
import it.avanscoperta.ddd.nrgsandbox.network.domain.events.CabinAddedToPatch;
import it.avanscoperta.ddd.nrgsandbox.network.domain.events.PatchCreated;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class Patch {

    @AggregateIdentifier
    private UUID patchId;

    private Patch() {}

    @CommandHandler
    public Patch(CreatePatch command) {
        apply(new PatchCreated(
                command.getPatchId(),
                command.getName(),
                command.getAuthor(),
                command.getDate(),
                command.getGoal()
        ));
    }

    @CommandHandler
    public void addCabin(AddCabin command) {
        // TODO: guard conditions here

        apply(new CabinAddedToPatch(
                command.getPatchId(),
                command.getCabinId(),
                command.getCoordinates(),
                command.getLabel(),
                command.getCabinType()
        ));
    }

    @EventSourcingHandler
    public void on(PatchCreated event) {
        this.patchId = event.getPatchId();
    }




}
