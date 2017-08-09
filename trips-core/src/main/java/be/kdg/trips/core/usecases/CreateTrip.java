package be.kdg.trips.core.usecases;

import be.kdg.trips.core.boundries.TripsRepository;
import be.kdg.trips.core.entities.Label;
import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Trip;

import java.util.ArrayList;
import java.util.List;

public class CreateTrip {
    TripsRepository tripsRepository;
    public void create(String name, String desc, List<Label> labels){
        Trip t = new Trip(name,desc,labels);
        tripsRepository.saveTrip(t);
    }
    public void addLocationToTrip(Location location, Trip trip){
        tripsRepository.addLocationToTrip(trip, location);
    }
    public void addLocationToTripWithIndex(Location location, Trip trip, int index){
        tripsRepository.addLocationToTrip(trip, location, index);
    }
    public void removeLocationFromTrip(Location location, Trip trip){
        tripsRepository.removeLocationToTrip(trip, location);
    }
    public void removeTrip(Trip t){
        tripsRepository.deleteTrip(t);
    }
}
