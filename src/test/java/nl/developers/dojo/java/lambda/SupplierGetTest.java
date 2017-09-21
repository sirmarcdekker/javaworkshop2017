package nl.developers.dojo.java.lambda;

import static java.lang.Math.random;
import static java.lang.Math.round;
import static nl.developers.dojo.java.model.Fixtures.OutdoorPlotFactory.aOutdoorPlot;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.util.function.Supplier;
import java.util.stream.Stream;

import com.spotify.hamcrest.optional.OptionalMatchers;
import nl.developers.dojo.java.model.Fixtures.OutdoorPlotFactory;
import nl.developers.dojo.java.model.OutdoorPlot;
import org.junit.Test;

public class SupplierGetTest {

    @Test
    public void firstResultTest() {
        Supplier<OutdoorPlot> sup = () -> aOutdoorPlot().withCost(2L).withSize(4L).build();

        OutdoorPlot plot = SupplierBasics.findCheapPlot(sup);

        assertThat(plot.getCost(), OptionalMatchers.optionalWithValue(equalTo(2L)));
        assertThat(plot.getSize(), equalTo(4L));
    }

    @Test
    public void withEmptyTest() {
        Supplier<OutdoorPlot> sup = () -> {
            OutdoorPlotFactory builder = aOutdoorPlot().withSize(round(random() * 10.0));
            Long cost = round(random() * 10.0);
            if (cost > 6L){
                builder.withCost(cost);
            }
            return builder.build();
        };

        Stream.generate(() -> true).limit(5).forEach(v -> {
            OutdoorPlot plot = SupplierBasics.findCheapPlot(sup);

            assertThat(plot.getCost(), OptionalMatchers.optionalWithValue());
            assertThat(plot.getSize(), greaterThan(plot.getCost().get()));
        });
    }

    @Test
    public void randomTest() {
        Supplier<OutdoorPlot> sup = () -> aOutdoorPlot().withCost(round(random() * 10.0)).withSize(round(random() * 10.0)).build();

        OutdoorPlot plot = SupplierBasics.findCheapPlot(sup);

        assertThat(plot.getCost(), OptionalMatchers.optionalWithValue());
        assertThat(plot.getSize(), greaterThan(plot.getCost().get()));
    }

}
