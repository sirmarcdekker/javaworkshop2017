package nl.developers.dojo.java.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private String contact;
    private Exhibit currentlyAt;
    private int tourLevel;
    private List<Guest> groupMembers = new ArrayList<>();

    public Group(String name, String contact, Exhibit location, int tourLevel) {
        this.name = name;
        this.contact = contact;
        this.currentlyAt = location;
        this.tourLevel = tourLevel;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Exhibit getCurrentlyAt() {
        return currentlyAt;
    }

    public int getTourLevel() {
        return tourLevel;
    }

    public List<Guest> getGroupMembers() {
        return groupMembers;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setCurrentlyAt(Exhibit currentlyAt) {
        this.currentlyAt = currentlyAt;
    }

    public void setTourLevel(Integer tourLevel) {
        this.tourLevel = tourLevel;
    }

    public void addGroupMember(Guest guest) {
        this.groupMembers.add(guest);
    }
}
