package be.kdg.trips.core.usecases;

import be.kdg.trips.core.boundries.TripRepository;
import be.kdg.trips.core.entities.Tag;
import be.kdg.trips.core.entities.Trip;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class FindTrips {
    private static final Logger LOGGER = LoggerFactory.getLogger(FindTrips.class);
    private TripRepository tripRepository;

    public FindTrips(TripRepository tripRepository) {

        this.tripRepository = tripRepository;
    }

    public Trip findTripById(int tripId){
        LOGGER.info("Find Trip By id '{0}'", tripId);
        return tripRepository.loadTripById(tripId);
    }

    public Trip findTripByName(String name){
        LOGGER.info("Find Trip By name '{0}'", name);
        return tripRepository.loadTripByName(name);
    }
    public List<Trip> findTripsByLabel(Tag[] labels){
        LOGGER.info("Find Trip by labels {0}", Arrays.toString(labels));
        return tripRepository.loadTripsByLabels(labels);
    }
}
