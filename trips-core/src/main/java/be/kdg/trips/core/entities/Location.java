package be.kdg.trips.core.entities;

import java.net.URL;
import java.util.List;

public class Location {
    private double latitude;
    private double longtitude;
    private String description;
    private String question;
    private List<URL> images;

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
}
