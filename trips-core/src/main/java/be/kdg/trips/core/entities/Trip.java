package be.kdg.trips.core.entities;

import java.util.List;

public class Trip {
    private String name;
    private String description;
    private List<Label> labels;
    private List<Location> locations;

    public Trip(String naam, String description, List<Label> labels) {
        this.name = naam;
        this.description = description;
        this.labels = labels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }


    public void addLocation(Location location){
        locations.add(location);
    }

    public void addLocation(int index , Location location){
        locations.add(index,location);
    }

    public void removeLocation(Location location){
        locations.remove(location);
    }
}
