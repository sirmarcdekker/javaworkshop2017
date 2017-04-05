package nl.developers.dojo.java.model;

public class ExhibitFixture {

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
}
