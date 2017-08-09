package be.kdg.trips.core.boundries;

import be.kdg.trips.core.entities.Label;
import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Trip;

import java.util.List;

public interface TripsRepository {
    Trip saveTrip(Trip trip);

    Trip loadTripByName(String name);
    List<Trip> loadTripsByLabels(Label[] labels);

    Trip addLocationToTrip(Trip trip, Location location, int index);
    Trip addLocationToTrip(Trip trip, Location location);
    Trip removeLocationToTrip(Trip trip, Location location);

    boolean deleteTrip(Trip t);
}
