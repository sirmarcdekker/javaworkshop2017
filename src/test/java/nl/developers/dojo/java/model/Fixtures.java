package nl.developers.dojo.java.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Fixtures {

    public static class ExhibitFactory {
        private String name = "Dinosaurs";
        private Location location = new Location("Animal Enclosure");

        private ExhibitFactory(){}

        public static ExhibitFactory aExhibit() {
            return new ExhibitFactory();
        }

        public ExhibitFactory withName(String name){
            this.name = name;
            return this;
        }

        public ExhibitFactory withLocation(Location location){
            this.location = location;
            return this;
        }

        public Exhibit build() {
            return new Exhibit(name, location);
        }
    }

    public static class RoomFactory {

        private String roomNumber;
        private String function;
        final private List<Location> neighbours = new ArrayList<>();

        private RoomFactory(){
        }

        public static RoomFactory aRoom() {
            return new RoomFactory();
        }

        public RoomFactory withFunction(String function) {
            this.function = function;
            return this;
        }

        public RoomFactory withNeighbour(Location location) {
            if(Objects.nonNull(location)){
                neighbours.add(location);
            }
            return this;
        }

        public RoomFactory withRoom(String roomNumber) {
            this.roomNumber = roomNumber;
            return this;
        }

        public Room build() {
            Room location = new Room(function);
            location.getNeighbours().addAll(neighbours);
            location.setRoomNumber(roomNumber);
            return location;
        }
    }

    public static class OutdoorPlotFactory {

        private String plotIdentifier = "A0";
        private Long size = 20L;
        private Long cost;
        protected String function;
        final protected List<Location> neighbours = new ArrayList<>();
        private OutdoorPlotFactory(){
        }

        public static OutdoorPlotFactory aOutdoorPlot() {
            return new OutdoorPlotFactory();
        }

        public OutdoorPlotFactory withFunction(String function) {
            this.function = function;
            return this;
        }

        public OutdoorPlotFactory withNeighbour(Location location) {
            if(Objects.nonNull(location)){
                neighbours.add(location);
            }
            return this;
        }

        public OutdoorPlotFactory withPlotIdentifier(String id) {
            this.plotIdentifier = id;
            return this;
        }

        public OutdoorPlotFactory withCost(Long cost) {
            this.cost = cost;
            return this;
        }

        public OutdoorPlotFactory withSize(Long size) {
            this.size = size;
            return this;
        }

        public OutdoorPlot build() {
            OutdoorPlot location = new OutdoorPlot(function);
            location.getNeighbours().addAll(neighbours);
            location.setPlotIdentifier(plotIdentifier);
            location.setCost(cost);
            location.setSize(size);
            return location;
        }
    }

    public static class GuestFactory {
        private String name;
        private Exhibit currentlyAt;
        private Integer tourLevel;

        private GuestFactory(){
        }

        public static GuestFactory aGuest(){
            return new GuestFactory();
        }

        public GuestFactory withName(String name) {
            this.name = name;
            return this;
        }

        public GuestFactory withTourLevel(Integer tourLevel) {
            this.tourLevel = tourLevel;
            return this;
        }

        public GuestFactory withCurrentlyAt(Exhibit currentlyAt) {
            this.currentlyAt = currentlyAt;
            return this;
        }

        public Guest build() {
            Guest guest = new Guest();
            guest.setCurrentlyAt(this.currentlyAt);
            guest.setName(name);
            guest.setTourLevel(tourLevel);
            return guest;
        }
    }

    public static class VisitorLogFactory {

        private Optional<LocalDate> logDate = Optional.empty();
        final private List<String> visitors = new ArrayList<>();

        private VisitorLogFactory(){
        }

        public static VisitorLogFactory aVisitorLog() {
            return new VisitorLogFactory();
        }

        public VisitorLogFactory withDate(LocalDate date) {
            logDate = Optional.ofNullable(date);
            return this;
        }

        public VisitorLogFactory withVisistor(String name) {
            visitors.add(name);
            return this;
        }

        public VisitorLog build() {
            VisitorLog result = new VisitorLog(logDate.orElseGet(LocalDate::now));
            visitors.forEach(result::addVisitor);
            return result;
        }
    }

    public static class GroupFactory {
        private String name = "NASA School Trip";
        private String contact = "Albert Einstein";
        private Exhibit currentlyAt = ExhibitFactory.aExhibit().withName("Entrance").build();
        private int tourLevel = 5;
        private List<Guest> groupMembers = new ArrayList<>();

        private GroupFactory() {
        }

        public static GroupFactory aGroup() {
            return new GroupFactory();
        }

        public GroupFactory withName(String name) {
            this.name = name;
            return this;
        }

        public GroupFactory withContact(String contact) {
            this.contact = contact;
            return this;
        }

        public GroupFactory withCurrentlyAt(Exhibit currentlyAt) {
            this.currentlyAt = currentlyAt;
            return this;
        }

        public GroupFactory withTourLevel(int tourLevel) {
            this.tourLevel = tourLevel;
            return this;
        }

        public GroupFactory withGroupMember(Guest groupMember) {
            this.groupMembers.add(groupMember);
            return this;
        }

        public Group build() {
            Group result = new Group(name, contact, currentlyAt, tourLevel);
            groupMembers.forEach(result::addGroupMember);
            return result;
        }
    }
}
