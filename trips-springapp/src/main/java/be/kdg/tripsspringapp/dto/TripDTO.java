package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.Label;
import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Trip;

import java.util.List;

public class TripDTO {
    private List<Label> labels;
    private String description;
    private String naam;
    private List<Location> locations;

    public TripDTO(Trip trip) {
        description = trip.getDescription();
        naam = trip.getName();
        labels = trip.getLabels();
    }

    public Trip toEntity() {
        return new Trip(this.naam,this.description,this.labels);
    }
}
