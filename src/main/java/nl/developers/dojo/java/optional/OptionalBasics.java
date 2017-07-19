package nl.developers.dojo.java.optional;

import java.util.Optional;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Guest;
import nl.developers.dojo.java.model.Location;

public class OptionalBasics {

    /**
     * Check if the exhibit is the one specified with name and return it's location as an optional.
     * Otherwise return an empty optional;
     * Test for this function are in test/nl.developers.dojo.java.optional.OptionalOfEmptyTest
     * @param name The name of the exhibit we are looking for
     * @param exhibit The exhibit we are checking now
     * @return the location of the exhibit if exhibit.name = name otherwise empty
     */
    public Optional<Location> getCorrectExhibitLocation(String name, Exhibit exhibit) {
        return null;
    }

    /**
     * Given an Exhibit return the function of it's location as an Optional or Optional empty if the function is null.
     * Do this without using an if statement.
     * Test for this function are in test/nl.developers.dojo.java.optional.OptionalOfNullableTest
     * @param exhibit The exhibit we need the location function of
     * @return An Optional of the function of the location of the exhibit if it exist Otherwise empty.
     */
    public Optional<String> getExhibitionLocationFunction(Exhibit exhibit){
        return null;
    }

    /**
     * Check if the the guest is currently at an exhibit if so return it's location.
     * Otherwise return an null;
     * Test for this function are in test/nl.developers.dojo.java.optional.OptionalisPresentTest
     * @param guest the guest who's location we are trying to find
     * @return the location of the exhibit if exhibit.name = name otherwise empty
     */
    public Location getVisitorLocation(Guest guest){
        return new Location();
    }

    /**
     * Return the name of a visitor. Assume it exists.
     * @param guest a guest with a provided name
     * @return the name of the guest
     */
    public String getVisitorName(Guest guest) {
        return null;
    }

    /**
     * Return the name of visitor if it has one otherwise use John Doe as a default.
     * @param guest a guest which might have a name
     * @return the name of guest is it has one otherwise return John Doe
     */
    public String getVisitorNameWithDefault(Guest guest) {
        return null;
    }
}
