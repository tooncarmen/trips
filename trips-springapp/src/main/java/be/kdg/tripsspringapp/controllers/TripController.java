package be.kdg.tripsspringapp.controllers;


import be.kdg.trips.core.entities.Location;
import be.kdg.trips.core.entities.Tag;
import be.kdg.trips.core.entities.Trip;
import be.kdg.trips.core.usecases.CreateTrip;
import be.kdg.trips.core.usecases.FindTrips;
import be.kdg.tripsspringapp.dto.LocationDTO;
import be.kdg.tripsspringapp.dto.TripDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/trip")
@CrossOrigin("http://localhost:4200")
public class TripController {

    @Autowired
    private FindTrips findTrips;
    @Autowired
    private CreateTrip createTrip;


    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public TripDTO saveTrip(@RequestBody TripDTO tripDTO) {
        Trip t = createTrip.create(tripDTO.toEntity());
        return new TripDTO(t);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addlocations/{tripid}")
    public TripDTO addLocationsToTrip(@RequestBody LocationDTO[] locationDTOS, @PathVariable("tripid") int tripId) {
        Trip t = findTrips.findTripById(tripId);
        for (LocationDTO locationDTO : locationDTOS) {
            createTrip.addLocationToTrip(locationDTO.toEntity(), t);
        }
        return new TripDTO(t);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addlocation/{tripid}")
    public TripDTO addTagsToTrip(@RequestBody TripDTO tripDTO) {

        createTrip.create(tripDTO.toEntity());
        return new TripDTO();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byname/{name}")
    public TripDTO loadTrip(@PathVariable("name") String name) {
        return new TripDTO(findTrips.findTripByName(name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byid/{id}")
    public TripDTO findById(@PathVariable("id") int id) {
        return new TripDTO(findTrips.findTripById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/locations/bytripid/{id}")
    public LocationDTO[] findLocationsByTripId(@PathVariable("id") int id) {
        List<Location> loc = findTrips.findTripById(id).getLocations();
        List<LocationDTO> locDTO = new ArrayList<>();

        loc.forEach(l -> locDTO.add(new LocationDTO(l, id)));
        return locDTO.toArray(new LocationDTO[locDTO.size()]);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findall")
    public TripDTO[] loadTrip() {
        List<TripDTO> allTripsDTO = new ArrayList<>();
        findTrips.findAllTrips().forEach(trip -> allTripsDTO.add(new TripDTO(trip)));

        return allTripsDTO.toArray(new TripDTO[allTripsDTO.size()]);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bylabel/{tag}")
    public List<TripDTO> getTrip(@PathVariable("tag") String tag) {
        Tag[] labels = {new Tag(tag)};
        List<TripDTO> tripDTOList = new ArrayList<>();
        findTrips.findTripsByLabel(labels).forEach(t -> tripDTOList.add(new TripDTO(t)));
        return tripDTOList;
    }
}
