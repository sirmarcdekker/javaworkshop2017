package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import nl.developers.dojo.java.model.Guest;
import org.junit.Test;

public class OptionalOrElseThrowTest {

    OptionalAdvance target = new OptionalAdvance();

    @Test
    public void allowedOnTourExact() throws IllegalAccessException{
       Guest guest = aGuest().withTourLevel(2).build();

        Boolean result = target.allowOnTour(guest, 2);

        assertThat(result, notNullValue());
        assertTrue(result);
    }

    @Test
    public void allowedOnTourWithRoom() throws IllegalAccessException{
        Guest guest = aGuest().withTourLevel(4).build();

        Boolean result = target.allowOnTour(guest, 2);

        assertThat(result, notNullValue());
        assertTrue(result);
    }

    @Test
    public void doNotAllowedOnTourWithRoom() throws IllegalAccessException{
        Guest guest = aGuest().withTourLevel(1).build();

        Boolean result = target.allowOnTour(guest, 2);

        assertThat(result, notNullValue());
        assertFalse(result);
    }

    @Test(expected = IllegalAccessException.class)
    public void noKnownTourLevel() throws IllegalAccessException{
        Guest guest = aGuest().build();

        target.allowOnTour(guest, 2);
    }
}
