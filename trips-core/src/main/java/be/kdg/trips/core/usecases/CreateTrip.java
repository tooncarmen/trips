package be.kdg.trips.core.usecases;

import be.kdg.trips.core.boundries.TripRepository;
import be.kdg.trips.core.entities.Tag;
import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Trip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CreateTrip {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTrip.class);
    private TripRepository tripRepository;

    public CreateTrip(TripRepository tripRepository) {

        this.tripRepository = tripRepository;
    }

    public Trip create(String name, String desc, List<Tag> labels) {
        LOGGER.info("Trip {}: created", name);
        Trip t = new Trip(name, desc, labels, new ArrayList<>());
        return tripRepository.saveTrip(t);
    }

    public Trip create(Trip t) {
        LOGGER.info("Trip {}: created", t.getName());
        return tripRepository.saveTrip(t);
    }

    public Trip addLocationsToTrip(Location[] locations, Trip trip) {
        LOGGER.info("Trip {}: locations added ({})", trip.getName(), locations.length);
        for (Location location : locations) {
            tripRepository.addLocationToTrip(trip, location);
        }
        return trip;
    }

    public Trip addLocationToTrip(Location location, Trip trip) {
        LOGGER.info("Trip {}: location added {1}", trip.getName(), location.toString());
        tripRepository.addLocationToTrip(trip, location);
        return trip;
    }

    public void addLocationToTripWithIndex(Location location, Trip trip, int index) {
        LOGGER.info("Trip {}: location added {} with index {}", trip.getName(), location.toString(), index);
        tripRepository.addLocationToTrip(trip, location, index);
    }

    public void removeLocationFromTrip(Location location, Trip trip) {
        LOGGER.info("Trip {}: removed location", trip.getName(), location.toString());
        tripRepository.removeLocationToTrip(trip, location);
    }

    public void removeTrip(Trip t) {
        LOGGER.info("Trip {}: removed", t.getName());
        tripRepository.deleteTrip(t);
    }
}
