package nl.developers.dojo.java.optional;

import java.util.Optional;
import java.util.function.Function;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Guest;
import nl.developers.dojo.java.model.Location;
import nl.developers.dojo.java.model.OutdoorPlot;
import nl.developers.dojo.java.model.VisitorLog;

public class OptionalAdvance {

    /**
     * Return the exhibit where the guest is at but only if it is in an outsideplot
     * @param guest the guest we are checking
     * @return The exhibit where the guest is locatted IFF the exhibit is on an outside plot Otherwise return null
     */
    public Optional<Exhibit> getGuestLocationIfOutside(Guest guest) {
        return null;
    }

    /**
     * Add the name of a guest to the visitor log if the visitor has a name.
     * @param guest the guest whose name we want to add to the log
     * @param log the log to add the name to
     */
    public void logKnownVisitors(Guest guest, VisitorLog log) {
    }

    /**
     * Generate a filename for a guest if he has a name. The filename should be build as follows:
     * visitornumber_(name with spaces replaced with '_').txt
     * @param guest the guest for which we are creating a file
     * @return the filename as described above IFF the guest has a known name otherwise empty()
     */
    public Optional<String> getGuestFileName(Guest guest) {
        return null;
    }

    /**
     * Return the cost of an outdoor plot if it is already present otherwise calculate the cost using the costCalculation function.
     * @param plot the plot for which we want to find the price
     * @param costCalculation the calculation to determine the cost.
     * @return cost of plot either from plot or calculated.
     */
    public Long determinePlotCost(OutdoorPlot plot, Function<OutdoorPlot, Long> costCalculation) {
        return null;
    }

    /**
     * Check if the guest is allowed on the tour.
     * @param guest the guest who is checked for the tour
     * @param tourLevel the level of the tour that is checking the guest
     * @return return true IFF guest.tourLevel >- tourLevel otherwise false
     * @throws IllegalAccessException if the guest has no tourlevel set throw an IllegalAccessException
     */
    public Boolean allowOnTour(Guest guest, int tourLevel) throws IllegalAccessException{
        return null;
    }

    /**
     * Given an guest with a current location find which location is the closed exit if easy to find.
     * Algorithem: if currentAt has no neighbors return empty
     * else if currentlyAtt location has one neighbor return optional of it
     * else if currentlyAt has multiple neighbors return one with function "Escape Route" if none exist return empty
     * @param guest
     * @return
     */
    public Optional<Location> findExitRoute(Guest guest) {
        return null;
    }
}
