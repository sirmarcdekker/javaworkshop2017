package nl.developers.dojo.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LocationFixture {

    public static class LocationFactory{

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
}
