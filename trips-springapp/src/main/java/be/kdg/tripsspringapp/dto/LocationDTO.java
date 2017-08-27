package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.Location;
import org.springframework.hateoas.ResourceSupport;

public class LocationDTO extends ResourceSupport {
    public int tripid;
    public Float lat;
    public Float lng;
    public String question;
    public String label;
    public String description;

    public LocationDTO() {
    }

    public LocationDTO(int tripid, Float lat, Float lng, String question, String label, String description) {
        this.tripid = tripid;
        this.lat = lat;
        this.lng = lng;
        this.question = question;
        this.label = label;
        this.description = description;
    }
    public Location toEntity(){
        return new Location(lat,lng,label,description,question);
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
