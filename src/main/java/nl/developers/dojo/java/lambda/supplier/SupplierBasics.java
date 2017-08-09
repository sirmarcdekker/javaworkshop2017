package nl.developers.dojo.java.lambda.supplier;

import java.util.function.Supplier;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Group;
import nl.developers.dojo.java.model.Guest;

/**
 * Supplier expresions allow us to simply pass object creation code between objects without actually making the objects until they are needed.
 */
public class SupplierBasics {

    /**
     * We need to provide the name of the exhibit in multiple places
     * and if it is not available we want to use the function of the location
     * To prevent having to do the logic for this multiple times we can make a supplier
     * @param exhibit The exhibit for which we want to get the name at various locations
     * @return exhibit.name IFF exhibit.name != null otherwise exhibit.location.function
     */
    public static Supplier<String> getNameSupplier(Exhibit exhibit) {
        return () -> null;
    }

    /**
     * Because makeing multiple members of a group separate can be tiring we want
     * a function that quickly creates a visitor of a group.
     * A member of a group has the same tour level and location (currentlyAt) as the rest of the group and
     * they are part of the group
     * @param group the group for which we want to create guests
     * @return a supplier that creates guests that are part of the group
     */
    public static Supplier<Guest> createGroupGuestSupplier(Group group) {
        return () -> {
            Guest result = new Guest();
            result.setTourLevel(group.getTourLevel());
            result.setCurrentlyAt(group.getCurrentlyAt());
            group.addGroupMember(result);
            return result;
        };
        //return () -> null;
    }
}
