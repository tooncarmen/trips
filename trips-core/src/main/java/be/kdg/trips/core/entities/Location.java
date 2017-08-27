package be.kdg.trips.core.entities;

import java.net.URL;
import java.util.List;

public class Location {
    private double latitude;
    private double longtitude;
    private String label;
    private String description;
    private String question;
    private List<URL> images;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                 + longtitude +
                ","
                + latitude +
                '}';
    }
}
