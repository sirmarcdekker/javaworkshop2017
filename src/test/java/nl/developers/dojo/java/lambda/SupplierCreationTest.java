package nl.developers.dojo.java.lambda;


import static nl.developers.dojo.java.model.Fixtures.ExhibitFactory.aExhibit;
import static nl.developers.dojo.java.model.Fixtures.OutdoorPlotFactory.aOutdoorPlot;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.function.Supplier;

import nl.developers.dojo.java.model.Exhibit;
import org.junit.Test;

public class SupplierCreationTest {

    @Test
    public void namePresentTest() {
        String name = "T-Rex";
        Exhibit exhibit = aExhibit().withName(name).build();

        Supplier<String> result = SupplierBasics.getNameSupplier(exhibit);

        assertThat(result, notNullValue());
        assertThat(result.get(), equalTo(name));
        assertThat(result.get(), equalTo(name));
        assertThat(result.get(), equalTo(name));
    }

    @Test
    public void nameNotPresentTest() {
        String name = "Dinosaur Corral";
        Exhibit exhibit = aExhibit().withName(name).withLocation(aOutdoorPlot().withFunction(name).build()).build();

        Supplier<String> result = SupplierBasics.getNameSupplier(exhibit);

        assertThat(result, notNullValue());
        assertThat(result.get(), equalTo(name));
        assertThat(result.get(), equalTo(name));
        assertThat(result.get(), equalTo(name));
    }
}
