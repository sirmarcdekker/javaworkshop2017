package nl.developers.dojo.java.model;

public class OutdoorPlot extends Location {

    private String plotIdentifier;
    private Long size;

    public String getPlotIdentifier() {
        return plotIdentifier;
    }

    public OutdoorPlot setPlotIdentifier(String plotIdentifier) {
        this.plotIdentifier = plotIdentifier;
        return this;
    }

    public Long getSize() {
        return size;
    }

    public OutdoorPlot setSize(Long size) {
        this.size = size;
        return this;
    }
}
