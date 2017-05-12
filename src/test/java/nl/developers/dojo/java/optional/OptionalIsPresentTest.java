package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.ExhibitFactory.aExhibit;
import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Guest;
import nl.developers.dojo.java.model.Location;
import org.junit.Test;

public class OptionalIsPresentTest {

    OptionalBasics target = new OptionalBasics();

    @Test
    public void noExhibitionReturnsNullTest(){
        Guest guest = aGuest().build();

        Location result = target.getVisitorLocation(guest);

        assertThat(result, nullValue());
    }

    @Test
    public void nullLocationOfExhibitionReturnsTest() {
        Guest guest = aGuest().withCurrentlyAt(aExhibit().withLocation(null).build()).build();

        Location result = target.getVisitorLocation(guest);

        assertThat(result, nullValue());
    }

    @Test
    public void exhibitionExsistingReturnsLocationTest() {
        Exhibit exhibit = aExhibit().build();
        Guest guest = aGuest().withCurrentlyAt(exhibit).build();

        Location result = target.getVisitorLocation(guest);

        assertThat(result, notNullValue());
        assertThat(result, equalTo(exhibit.getLocation()));
    }
}
