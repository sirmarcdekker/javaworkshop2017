package nl.developers.dojo.java.model;

import java.util.Optional;

public class OutdoorPlot extends Location {

    private String plotIdentifier;
    private Long size;
    private Optional<Long> cost;

    public OutdoorPlot(String function) {
        super(function);
    }

    public String getPlotIdentifier() {
        return plotIdentifier;
    }

    public OutdoorPlot setPlotIdentifier(String plotIdentifier) {
        this.plotIdentifier = plotIdentifier;
        return this;
    }

    public Optional<Long> getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = Optional.ofNullable(cost);
    }

    public Long getSize() {
        return size;
    }

    public OutdoorPlot setSize(Long size) {
        this.size = size;
        return this;
    }
}
