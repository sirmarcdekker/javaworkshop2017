package nl.developers.dojo.java.model;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private String function;
    final private List<Location> neighbours = new ArrayList<>();

    public Location(){

    }

    public Location(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<Location> getNeighbours() {
        return neighbours;
    }
}
