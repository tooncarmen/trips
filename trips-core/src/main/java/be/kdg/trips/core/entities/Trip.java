package be.kdg.trips.core.entities;

import java.util.List;

public class Trip {
    private int id;
    private String name;
    private String description;
    private List<Tag> tags;
    private List<Location> locations;

    public Trip(String name, String description, List<Tag> tags, List<Location> locations) {
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.locations = locations;
    }

    public void setId(int id) {
        if (this.id == 0)
            this.id = id;
    }

    public int getId() {
        return id;
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


    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addLocation(int index, Location location) {
        locations.add(index, location);
    }

    public void removeLocation(Location location) {
        locations.remove(location);
    }
}
