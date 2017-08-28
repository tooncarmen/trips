package be.kdg.tripsspringapp.dto;


import be.kdg.trips.core.entities.Trip;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;

public class TripDTO {
    private int id;
    private String name;
    private String description;
//    private List<String> tags;
//    private List<LocationDTO> locations;

    public TripDTO() {
    }

    public TripDTO(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TripDTO(Trip trip) {
        this.id = trip.getId();
        this.name = trip.getName();
        this.description = trip.getDescription();
    }

    public Trip toEntity() {
        Trip t = new Trip(this.name, this.description, new ArrayList<>(), new ArrayList<>());
        return t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
