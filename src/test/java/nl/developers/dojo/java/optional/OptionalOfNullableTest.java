package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.ExhibitFixture.ExhibitFactory.aExhibit;
import static nl.developers.dojo.java.model.LocationFixture.LocationFactory.aLocation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import nl.developers.dojo.java.model.Exhibit;
import org.junit.Test;

public class OptionalOfNullableTest {

    OptionalBasics target = new OptionalBasics();

    @Test
    public void locationWithFunction() {
        String function = "Exhibitions";
        Exhibit exhibit = aExhibit().withLocation(aLocation().withFunction(function)
                                                             .build())
                                    .build();

        Optional<String> result = target.getExhibitionLocationFunction(exhibit);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(function));
    }

    @Test
    public void locationWithoutFunction() {
        Exhibit exhibit = aExhibit().withLocation(aLocation().withFunction(null)
                                                             .build())
                                    .build();
        Optional<String> result = target.getExhibitionLocationFunction(exhibit);



        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(false));
    }

    @Test
    public void locationWithEmptyFunction() {
        String function = "";
        Exhibit exhibit = aExhibit().withLocation(aLocation().withFunction(function)
                                                             .build())
                                    .build();

        Optional<String> result = target.getExhibitionLocationFunction(exhibit);

        assertThat(result, notNullValue());
        assertThat(result.isPresent(), equalTo(true));
        assertThat(result.get(), equalTo(function));
    }
}
