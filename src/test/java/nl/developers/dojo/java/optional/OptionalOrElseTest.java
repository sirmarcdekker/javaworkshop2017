package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import nl.developers.dojo.java.model.Guest;
import org.junit.Test;

public class OptionalOrElseTest {

    OptionalBasics target = new OptionalBasics();

    @Test
    public void noNamePresentTest(){
        Guest guest = aGuest().build();

        assertThat(target.getVisitorNameWithDefault(guest), equalTo("John Doe"));
    }

    @Test
    public void nameIsEmptyTest() {
        Guest guest = aGuest().withName("").build();

        assertThat(target.getVisitorNameWithDefault(guest), equalTo(""));
    }

    @Test
    public void nameNormalTest() {
        String name = "piet";
        Guest guest = aGuest().withName(name).build();

        assertThat(target.getVisitorNameWithDefault(guest), equalTo(name));
    }
}
