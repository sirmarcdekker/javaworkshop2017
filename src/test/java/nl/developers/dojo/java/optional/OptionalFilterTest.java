package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.ExhibitFactory.aExhibit;
import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static nl.developers.dojo.java.model.Fixtures.OutdoorPlotFactory.aOutdoorPlot;
import static nl.developers.dojo.java.model.Fixtures.RoomFactory.aRoom;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Guest;
import org.junit.Test;

public class OptionalFilterTest {

    OptionalAdvance target = new OptionalAdvance();

    @Test
    public void noExhibitTest() {
        Guest guest = aGuest().build();

        Optional<Exhibit> result = target.getGuestLocationIfOutside(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void exhibitIsoutsidePlotTest() {
        Guest guest = aGuest().withCurrentlyAt(aExhibit().withName("Omniraptors").withLocation(aOutdoorPlot().build()).build()).build();

        Optional<Exhibit> result = target.getGuestLocationIfOutside(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get().getName(), equalTo("Omniraptors"));
    }

    @Test
    public void exhibitIsInsisde() {
        Guest guest = aGuest().withCurrentlyAt(aExhibit().withLocation(aRoom().build()).build()).build();

        Optional<Exhibit> result = target.getGuestLocationIfOutside(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }
}
