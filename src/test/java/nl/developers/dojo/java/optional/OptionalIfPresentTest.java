package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static nl.developers.dojo.java.model.Fixtures.VisitorLogFactory.aVisitorLog;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import nl.developers.dojo.java.model.Guest;
import nl.developers.dojo.java.model.VisitorLog;
import org.junit.Test;

public class OptionalIfPresentTest {

    OptionalAdvance target = new OptionalAdvance();

    @Test
    public void noNameTest() {
        Guest guest = aGuest().build();
        VisitorLog log = aVisitorLog().build();

        target.logKnownVisitors(guest, log);

        assertThat(log.getVisitors().size(), equalTo(0));
    }

    @Test
    public void newNameTest() {
        Guest guest = aGuest().withName("Freddy").build();
        VisitorLog log = aVisitorLog().build();

        target.logKnownVisitors(guest, log);

        assertThat(log.getVisitors().size(), equalTo(1));
        assertThat(log.getVisitors().get(0), equalTo("Freddy"));
    }

    @Test
    public void addNameTest() {
        Guest guest = aGuest().withName("Freddy").build();
        VisitorLog log = aVisitorLog().withVisistor("George").build();

        target.logKnownVisitors(guest, log);

        assertThat(log.getVisitors().size(), equalTo(2));
        assertThat(log.getVisitors(), containsInAnyOrder(equalTo("Freddy"), equalTo("George")));
    }

    @Test
    public void addMultipleTest() {
        Guest guest1 = aGuest().withName("Freddy").build();
        Guest guest2 = aGuest().withName("Bobby").build();
        Guest guest3 = aGuest().withName("Nodwick").build();
        VisitorLog log = aVisitorLog().withVisistor("George").build();

        target.logKnownVisitors(guest1, log);
        target.logKnownVisitors(guest2, log);
        target.logKnownVisitors(guest3, log);

        assertThat(log.getVisitors().size(), equalTo(4));
        assertThat(log.getVisitors(), containsInAnyOrder(equalTo("Freddy"),
                                                         equalTo("George"),
                                                         equalTo("Nodwick"),
                                                         equalTo("Bobby")));
    }
}
