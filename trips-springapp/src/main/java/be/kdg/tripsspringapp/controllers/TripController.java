package be.kdg.tripsspringapp.controllers;


import be.kdg.trips.core.entities.Tag;
import be.kdg.trips.core.entities.Trip;
import be.kdg.trips.core.usecases.CreateTrip;
import be.kdg.trips.core.usecases.FindTrips;
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
    public TripDTO saveTrip(TripDTO tripDTO) {
        Trip t = tripDTO.toEntity();
        t = createTrip.create(t);
        return new TripDTO(t);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/byname/{name}")
    public TripDTO loadTrip(@PathVariable("name") String name) {
        return new TripDTO(findTrips.findTripByName(name));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bylabel/{tag}")
    public List<TripDTO> saveTrip(@PathVariable("tag") String tag) {
        Tag[] labels = {new Tag(tag)};
        List<TripDTO> tripDTOList = new ArrayList<>();
        findTrips.findTripsByLabel(labels).forEach(t -> tripDTOList.add(new TripDTO(t)));
        return tripDTOList;
    }
    // add locations or saved in trip?
}
