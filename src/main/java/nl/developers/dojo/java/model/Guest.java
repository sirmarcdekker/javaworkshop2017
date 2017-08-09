package nl.developers.dojo.java.model;

import static java.util.Optional.empty;

import java.util.Optional;

public class Guest {

    private static long VISITOR_COUNT = 0;

    private long visitorNumber;
    private Optional<String> name = empty();
    private Optional<Exhibit> currentlyAt = empty();
    private Optional<Integer> tourLevel = empty();

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
