package it.avanscoperta.ddd.nrgsandbox.network.domain.events;

import java.time.LocalDate;
import java.util.UUID;

public class PatchCreated {
    private final UUID patchId;
    private final String name;
    private final String author;
    private final LocalDate date;
    private final String goal;

    public PatchCreated(UUID patchId, String name, String author, LocalDate date, String goal) {
        this.patchId = patchId;
        this.name = name;
        this.author = author;
        this.date = date;
        this.goal = goal;
    }

    public UUID getPatchId() {
        return patchId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getGoal() {
        return goal;
    }
}
