package be.kdg.trips.core.entities;

public class Label {
    public Label(String tag) {
        this.tag = tag;
    }

    private String tag;

    @Override
    public String toString() {
        return "#"+tag;
    }
}
