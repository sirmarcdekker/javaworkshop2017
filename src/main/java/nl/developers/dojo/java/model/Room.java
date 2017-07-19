package nl.developers.dojo.java.model;

public class Room extends Location {

    private String roomNumber;

    public Room(String function) {
        super(function);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
