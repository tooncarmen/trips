package be.kdg.trips.core.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s) {
        super("NOT FOUND:" + s);
    }
}
