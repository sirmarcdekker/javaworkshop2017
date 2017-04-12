package nl.developers.dojo.java.model;

import java.util.Objects;

import com.sun.istack.internal.NotNull;

public class Exhibit {

    private String name;
    private Location location;

    public Exhibit(@NotNull Location location) {
        this.name = "";
        this.location = location;
    }

    public Exhibit(String name,@NotNull  Location location) {
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
        if(Objects.nonNull(location)){
            this.location = location;
        }
    }
}
