package be.kdg.trips.core.entities;

public class Tag {
    public Tag(String tag) {
        this.tag = tag;
    }

    private String tag;

    @Override
    public String toString() {
        return "#"+tag;
    }
}
