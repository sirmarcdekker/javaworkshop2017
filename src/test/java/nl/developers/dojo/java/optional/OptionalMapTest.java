package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import nl.developers.dojo.java.model.Guest;
import org.junit.Test;

public class OptionalMapTest {

    OptionalAdvance target = new OptionalAdvance();

    @Test
    public void noNameTest() {
        Guest guest = aGuest().build();

        Optional<String> result = target.getGuestFileName(guest);

        assertThat(result, notNullValue());
        assertFalse(result.isPresent());
    }

    @Test
    public void nameWithoutSpaceTest() {
        String name = "Klaas";
        Guest guest = aGuest().withName(name).build();

        Optional<String> result = target.getGuestFileName(guest);

        assertThat(result, notNullValue());
        assertTrue(result.isPresent());
        assertThat(result.get(), equalTo(String.format("%d_%s.txt", guest.getVisitorNumber(), name)));
    }

    @Test
    public void nameWithSpaceTest() {
        String name = "Piet Hein";
        Guest guest = aGuest().withName(name).build();

        Optional<String> result = target.getGuestFileName(guest);

        assertThat(result, notNullValue());
        assertTrue(result.isPresent());
        assertThat(result.get(), equalTo(String.format("%d_%s.txt", guest.getVisitorNumber(), name.replace(' ', '_'))));
    }

    @Test
    public void nameWithMultiSpaceTest() {
        String name = "Jan Piet Joris";
        Guest guest = aGuest().withName(name).build();

        Optional<String> result = target.getGuestFileName(guest);

        assertThat(result, notNullValue());
        assertTrue(result.isPresent());
        assertThat(result.get(), equalTo(String.format("%d_%s.txt", guest.getVisitorNumber(), name.replace(' ', '_'))));
    }

    @Test
    public void nameWithSpaceAndUnderscoreTest() {
        String name = "Jan_Willem Wouters";
        Guest guest = aGuest().withName(name).build();

        Optional<String> result = target.getGuestFileName(guest);

        assertThat(result, notNullValue());
        assertTrue(result.isPresent());
        assertThat(result.get(), equalTo(String.format("%d_%s.txt", guest.getVisitorNumber(), name.replace(' ', '_'))));
    }
}
