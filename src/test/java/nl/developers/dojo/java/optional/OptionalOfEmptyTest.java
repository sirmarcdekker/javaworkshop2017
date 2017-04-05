package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.ExhibitFixture.ExhibitFactory.aExhibit;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import nl.developers.dojo.java.model.Exhibit;
import nl.developers.dojo.java.model.Location;
import org.junit.Test;

public class OptionalOfEmptyTest {

    OptionalBasics target = new OptionalBasics();

    @Test
    public void correctExhibitTest() {
        String name = "Dodo";
        Exhibit exhibit = aExhibit().withName(name).build();
        Optional<Location> result = target.getCorrectExhibitLocation(name, exhibit);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(exhibit.getLocation()));
    }

    @Test
    public void notMatchNametTest() {
        String name = "Dodo";
        Exhibit exhibit = aExhibit().withName(name).build();
        Optional<Location> result = target.getCorrectExhibitLocation(name + name, exhibit);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void emptyStringTest() {
        String name = "Dodo";
        Exhibit exhibit = aExhibit().withName(name).build();
        Optional<Location> result = target.getCorrectExhibitLocation("", exhibit);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void correctBothEmptyTest() {
        String name = "";
        Exhibit exhibit = aExhibit().withName("").build();
        Optional<Location> result = target.getCorrectExhibitLocation(name, exhibit);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(exhibit.getLocation()));
    }
}
