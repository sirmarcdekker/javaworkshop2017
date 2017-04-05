package nl.developers.dojo.java.model;

import java.time.LocalDateTime;

public class Visit {

    private Guest guest;
    private Exhibit exhibit;
    private LocalDateTime time;

    public Visit(Guest guest, Exhibit exhibit) {
        this.guest = guest;
        this.exhibit = exhibit;
        this.time = LocalDateTime.now();
    }

    public Visit(Guest guest, Exhibit exhibit, LocalDateTime time) {
        this.guest = guest;
        this.exhibit = exhibit;
        this.time = time;
    }

    public Guest getGuest() {
        return guest;
    }

    public Exhibit getExhibit() {
        return exhibit;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
