package nl.developers.dojo.java.model;

import java.util.Optional;

public class Guest {

    private static long VISITOR_COUNT = 0;

    private long visitorNumber;
    private Optional<String> name;
    private Optional<Exhibit> currentlyAt;

    public Guest(){
        this.visitorNumber = VISITOR_COUNT++;
    }

    public long getVisitorNumber() {
        return visitorNumber;
    }

    public Optional<String> getName() {
        return name;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public Optional<Exhibit> getCurrentlyAt() {
        return currentlyAt;
    }

    public void setCurrentlyAt(Optional<Exhibit> currentlyAt) {
        this.currentlyAt = currentlyAt;
    }
}
