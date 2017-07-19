package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.ExhibitFactory.aExhibit;
import static nl.developers.dojo.java.model.Fixtures.GuestFactory.aGuest;
import static nl.developers.dojo.java.model.Fixtures.RoomFactory.aRoom;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import nl.developers.dojo.java.model.Guest;
import nl.developers.dojo.java.model.Location;
import org.junit.Test;

public class OptionalFlatMapTest {

    OptionalAdvance target = new OptionalAdvance();

    @Test
    public void guestHasNoExhibit() {
        Guest guest = aGuest().build();

        Optional<Location> result = target.findExitRoute(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void guestIsAtExhibitWithoutNeighbours() {
        Guest guest = aGuest().withCurrentlyAt(aExhibit().withLocation(aRoom().build()).build()).build();

        Optional<Location> result = target.findExitRoute(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void guestIsAtExhibitWithSingleNeighbours() {
        Guest guest = aGuest().withCurrentlyAt(
                aExhibit().withLocation(
                        aRoom().withNeighbour(
                                aRoom().withFunction("hallway").build()).build()).build()).build();

        Optional<Location> result = target.findExitRoute(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get().getFunction(), equalTo("hallway"));
    }

    @Test
    public void guestIsAtExhibitWithMultipleNeighboursWithoutEscapeRoute() {
        Guest guest = aGuest().withCurrentlyAt(
                aExhibit().withLocation(aRoom().withNeighbour(aRoom().withFunction("Hallway").build())
                                               .withNeighbour(aRoom().withFunction("Toilet").build())
                                               .build()).build()).build();

        Optional<Location> result = target.findExitRoute(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void guestIsAtExhibitWithMultipleNeighboursWithEscapeRoute() {
        Guest guest = aGuest().withCurrentlyAt(
                aExhibit().withLocation(aRoom().withNeighbour(aRoom().withFunction("Hallway").build())
                                               .withNeighbour(aRoom().withFunction("Toilet").build())
                                               .withNeighbour(aRoom().withFunction("Escape Route").build())
                                               .build()).build()).build();

        Optional<Location> result = target.findExitRoute(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get().getFunction(), equalTo("Escape Route"));
    }

    @Test
    public void guestIsAtExhibitWithMultipleNeighboursWithMultipleEscapeRoutes() {
        Guest guest = aGuest().withCurrentlyAt(
                aExhibit().withLocation(aRoom().withNeighbour(aRoom().withFunction("Hallway").build())
                                               .withNeighbour(aRoom().withFunction("Toilet").build())
                                               .withNeighbour(aRoom().withFunction("Escape Route").build())
                                               .withNeighbour(aRoom().withFunction("Escape Route").build())
                                               .build()).build()).build();

        Optional<Location> result = target.findExitRoute(guest);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get().getFunction(), equalTo("Escape Route"));
    }
}
