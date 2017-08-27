package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.TripRepository;
import be.kdg.trips.core.entities.Tag;
import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Trip;
import be.kdg.trips.core.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InMemoryTripRepo implements TripRepository {
    List<Trip> trips;

    public InMemoryTripRepo() {
        this.trips = new ArrayList<>();
        seed();
    }

    @Override
    public Trip saveTrip(Trip trip) {
        trip.setId(trips.size());
        this.trips.add(trip);
        return trip;
    }

    @Override
    public Trip loadTripById(int tripId) {
        Optional<Trip> tripOptional = trips.stream().filter(t -> t.getId() == tripId).findFirst();
        if (!tripOptional.isPresent()) throw new NotFoundException("trip not found with id " + tripId);
        return tripOptional.orElse(null);
    }


    @Override
    public Trip loadTripByName(String name) {
        Optional<Trip> tripOptional = trips.stream().filter(t -> t.getName().equals(name)).findFirst();
        if (!tripOptional.isPresent()) throw new NotFoundException("trip not found with name " + name);
        return tripOptional.orElse(null);
    }

    @Override
    public List<Trip> loadTripsByLabels(Tag[] labels) {

        List<Trip> foundtrips = new ArrayList<>();
        for (Trip trip : trips) {
            for (Tag label : labels) {
                if (trip.getTags().contains(label)) foundtrips.add(trip);
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

    private void seed(){
//        {"name":"lekker zee","description":"fuck this",
//      "tags":["im","dead","zee"],
//      "locations":[{"lat":51.14467892424189,"lng":2.7046966552734375,"question":"","label":"Nieuwpoort","description":""},
//                  {"lat":51.19203943460963,"lng":2.828625440597534,"question":"","label":"Middelkerke","description":""},
//                  {"lat":51.27587720748061,"lng":3.0284392833709717,"question":"","label":"De Haan","description":""}]}
        List<Tag> tags  = new ArrayList<>();
        tags.add(new Tag("Zee"));
        tags.add(new Tag("Strand"));
        tags.add(new Tag("Zon"));
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(51.14467892424189,2.7046966552734375, "Nieuwpoort","","" ));
        locations.add(new Location(51.19203943460963,2.828625440597534, "Middelkerke","","" ));
        locations.add(new Location(51.27587720748061,2.0284392833709717, "De Haan","","" ));
        Trip t = new Trip("Dag aan zee!", "een tochtje om goed uit te waaien aan zee",tags, locations );
        saveTrip(t);
//        {"name":"lekker zee","description":"fuck this","tags":["im","dead","zee"],
//            "locations":[{"lat":50.143686130902424,"lng":5.73211669921875,"question":"","label":"","description":""},
//            {"lat":50.1178263983354,"lng":5.703787207603455,"question":"","label":"","description":""},
//            {"lat":50.12905233906265,"lng":5.791334509849548,"question":"","label":"","description":""}]}

        List<Tag> tags2  = new ArrayList<>();
        tags.add(new Tag("Ardennen"));
        tags.add(new Tag("Kamperen"));
        tags.add(new Tag("Wandelen"));
        List<Location> locations2 = new ArrayList<>();
        locations.add(new Location(50.143686130902424,5.73211669921875, "Achouffe","Hier is een goede overnachtings plek","" ));
        locations.add(new Location(50.1178263983354,5.703787207603455, "Engeux","","" ));
        locations.add(new Location(50.12905233906265,5.791334509849548, "Houffalize","Mooi eindpunt, goede terrasjes ","" ));
        Trip t2 = new Trip("Wandeltocht in de Ardennen!", "Een 3 daagse wandeltocht door bos en velden.",tags, locations );
        saveTrip(t);
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
