package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Tag;

import be.kdg.trips.core.entities.Trip;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class TripDTO extends ResourceSupport{
    private int id;
    private String name;
    private String description;
//    private List<String> tags;
//    private List<LocationDTO> locations;

    public TripDTO() {
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

}
