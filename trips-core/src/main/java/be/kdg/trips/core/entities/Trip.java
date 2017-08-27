package be.kdg.trips.core.entities;

import java.util.List;

public class Trip {
    private String name;
    private String description;
    private List<Tag> tags;
    private List<Location> locations;

    public Trip(String naam, String description, List<Tag> tags) {
        this.name = naam;
        this.description = description;
        this.tags = tags;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
