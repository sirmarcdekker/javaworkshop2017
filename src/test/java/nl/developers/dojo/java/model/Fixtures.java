package nl.developers.dojo.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Fixtures {

    public static class ExhibitFactory {
        private String name = "Dinosaurs";
        private Location location = new Location("Animal Enclosure");

        private ExhibitFactory(){}

        public static ExhibitFactory aExhibit() {
            return new ExhibitFactory();
        }

        public ExhibitFactory withName(String name){
            this.name = name;
            return this;
        }

        public ExhibitFactory withLocation(Location location){
            this.location = location;
            return this;
        }

        public Exhibit build() {
            return new Exhibit(name, location);
        }
    }

    public static class LocationFactory {

        private String function;
        final private List<Location> neighbours = new ArrayList<>();

        private LocationFactory(){
        }

        public static LocationFactory aLocation() {
            return new LocationFactory();
        }

        public LocationFactory withFunction(String function) {
            this.function = function;
            return this;
        }

        public LocationFactory withNeighbour(Location location) {
            if(Objects.nonNull(location)){
                neighbours.add(location);
            }
            return this;
        }

        public Location build() {
            Location location = new Location(function);
            location.getNeighbours().addAll(neighbours);
            return location;
        }
    }

    public static class GuestFactory {
        private Optional<String> name = Optional.empty();
        private Optional<Exhibit> currentlyAt = Optional.empty();

        private GuestFactory(){
        }

        public static GuestFactory aGuest(){
            return new GuestFactory();
        }

        public GuestFactory withName(String name) {
            this.name = Optional.of(name);
            return this;
        }

        public GuestFactory withCurrentlyAt(Exhibit currentlyAt) {
            this.currentlyAt = Optional.of(currentlyAt);
            return this;
        }

        public Guest build() {
            Guest guest = new Guest();
            guest.setCurrentlyAt(this.currentlyAt);
            guest.setName(name);
            return guest;
        }
    }
}
