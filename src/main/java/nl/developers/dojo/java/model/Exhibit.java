package nl.developers.dojo.java.model;

public class Exhibit {

    private String name;
    private Location location;

    public Exhibit(Location location) {
        this.name = "";
        this.location = location;
    }

    public Exhibit(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
