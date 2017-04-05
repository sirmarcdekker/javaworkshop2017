package nl.developers.dojo.java.optional;

import java.util.Optional;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Location;

public class OptionalBasics {

    /**
     * Check if the exhibit is the one specified with name and return it's location as an optional.
     * Otherwise return an empty optional;
     * @param name The name of the exhibit we are looking for
     * @param exhibit The exhibit we are checking now
     * @return the location of the exhibit if exhibit.name = name otherwise empty
     */
    public Optional<Location> getCorrectExhibitLocation(String name, Exhibit exhibit) {
        //return name.equals(exhibit.getName()) ? Optional.of(exhibit.getLocation()) : Optional.<Location>empty();
        return null;
    }
}
