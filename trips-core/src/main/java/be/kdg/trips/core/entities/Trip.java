package be.kdg.trips.core.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trip {
    private String naam;
    private String omschrijving;
    private List<Label> labels;
    private List<Location> locations;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }


    public void addLocation(Location location){
        locations.add(location);
    }

    public void addLocation(int index , Location location){
        locations.add(index,location);
    }

    public void removeLocation(Location location){
        locations.remove(location);
    }
}
