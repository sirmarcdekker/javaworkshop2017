package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.NoSuchElementException;

import nl.developers.dojo.java.model.Guest;
import org.junit.Test;

public class OptionalGetTest {

    OptionalBasics target = new OptionalBasics();

    @Test(expected = NoSuchElementException.class)
    public void noNamePresentTest(){
        Guest guest = aGuest().build();

        target.getVisitorName(guest);
    }

    @Test
    public void nameIsEmptyTest() {
        Guest guest = aGuest().withName("").build();

        assertThat(target.getVisitorName(guest), equalTo(""));
    }

    @Test
    public void nameNormalTest() {
        String name = "piet";
        Guest guest = aGuest().withName(name).build();

        assertThat(target.getVisitorName(guest), equalTo(name));
    }
}
