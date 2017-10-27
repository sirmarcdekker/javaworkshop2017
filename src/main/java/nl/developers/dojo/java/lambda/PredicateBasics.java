package nl.developers.dojo.java.lambda;

import java.util.function.Predicate;

import nl.developers.dojo.java.model.Group;
import nl.developers.dojo.java.model.Guest;

/**
 * A Predicate allows you to define a true/false check on a an Class and then use that test multiple times.
 */
public class PredicateBasics {

    //creation

    /**
     * We need to create a Predicate that takes a Guest and checks if that guest is part of validationGroup.
     * @param validationGroup the group for which we want to see if guest are part of it.
     * @return a predicate that returns true IFF his guest is part of validationGroup Otherwise returns false
     */
    public Predicate<Guest> createPartOfGroupPredicate(Group validationGroup) {
        return guest -> validationGroup.getGroupMembers().contains(guest);
        //return null;
    }

    //test
    public 
    //negate
    //and
    //or
}
