package nl.developers.dojo.java.optional;

import static nl.developers.dojo.java.model.Fixtures.OutdoorPlotFactory.aOutdoorPlot;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import nl.developers.dojo.java.model.OutdoorPlot;
import org.junit.Test;

public class OptionalOrElseGetTest {

    OptionalAdvance target = new OptionalAdvance();

    @Test
    public void knownCostTest() {
        OutdoorPlot plot = aOutdoorPlot().withSize(20L).withCost(10L).build();
        assertThat(target.determinePlotCost(plot, p -> {
            fail();
            return p.getSize();
        }), equalTo(10L));
    }

    @Test
    public void unKnownCostTest() {
        OutdoorPlot plot = aOutdoorPlot().withSize(50L).build();
        assertThat(target.determinePlotCost(plot, OutdoorPlot::getSize), equalTo(50L));
    }

    @Test
    public void randomCheckTest() {
        Long value = Math.round(Math.random() * Long.MAX_VALUE);
        OutdoorPlot plot = aOutdoorPlot().withSize(50L).build();
        assertThat(target.determinePlotCost(plot, p -> value), equalTo(value));
    }
}
