package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.TripRepository;
import be.kdg.trips.core.entities.Label;
import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Trip;
import be.kdg.trips.core.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTripRepo implements TripRepository {
    List<Trip> trips;

    public InMemoryTripRepo() {
        this.trips = new ArrayList<>();
    }

    @Override
    public Trip saveTrip(Trip trip) {
        this.trips.add(trip);
        return trip;
    }


    @Override
    public Trip loadTripByName(String name) {
        Optional<Trip> tripOptional = trips.stream().filter(t -> t.getName().equals(name)).findFirst();
        if (!tripOptional.isPresent()) throw new NotFoundException("trip not found with name " + name);
        return tripOptional.orElse(null);
    }

    @Override
    public List<Trip> loadTripsByLabels(Label[] labels) {

        List<Trip> foundtrips = new ArrayList<>();
        for (Trip trip : trips) {
            for (Label label : labels) {
                if (trip.getLabels().contains(label)) foundtrips.add(trip);
            }
        }
        if(foundtrips.isEmpty()) throw new  NotFoundException("No trips found with given labels");
        return foundtrips;
    }

    @Override
    public Trip addLocationToTrip(Trip trip, Location location, int index) {
        Trip t = getTrip(trip);
        t.addLocation(index, location);

        return trip;
    }

    @Override
    public Trip addLocationToTrip(Trip trip, Location location) {
        Trip t = getTrip(trip);
        t.addLocation(location);
        saveTrip(t);

        return t;
    }

    private Trip getTrip(Trip trip) {
        Optional<Trip> foundTrip = trips.stream().filter(t -> t.equals(trip)).findFirst();
        if(!foundTrip.isPresent()) throw new NotFoundException("there is no such trip");

        return foundTrip.orElse(null);
    }

    @Override
    public Trip removeLocationToTrip(Trip trip, Location location) {
        Trip t = getTrip(trip);
        t.removeLocation(location);
        return t;
    }

    @Override
    public boolean deleteTrip(Trip t) {
       return trips.remove(t);
    }
}
