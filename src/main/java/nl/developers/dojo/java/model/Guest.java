package nl.developers.dojo.java.model;

import java.util.Optional;

public class Guest {

    private static long VISITOR_COUNT = 0;

    private long visitorNumber;
    private Optional<String> name;
    private Optional<Exhibit> currentlyAt;
    private Optional<Integer> tourLevel;

    public Guest(){
        this.visitorNumber = VISITOR_COUNT++;
    }

    public long getVisitorNumber() {
        return visitorNumber;
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<Integer> getTourLevel() {
        return tourLevel;
    }

    public void setTourLevel(Integer tourLevel) {
        this.tourLevel = Optional.ofNullable(tourLevel);
    }

    public void setName(String name) {
        this.name = Optional.ofNullable(name);
    }

    public Optional<Exhibit> getCurrentlyAt() {
        return currentlyAt;
    }

    public void setCurrentlyAt(Exhibit currentlyAt) {
        this.currentlyAt = Optional.ofNullable(currentlyAt);
    }
}
