package be.kdg.trips.core.entities;

import java.time.LocalDateTime;

public class Invitation {
    private boolean confirmed;
    private String inviteeEmail;
    private User inviter;
    private Trip trip;
    private LocalDateTime date;

    public Invitation(String inviteeEmail, User inviter, Trip trip, LocalDateTime date) {
        this.inviteeEmail = inviteeEmail;
        this.inviter = inviter;
        this.trip = trip;
        this.date = date;
        this.confirmed =false;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getInviteeEmail() {
        return inviteeEmail;
    }

    public void setInviteeEmail(String inviteeEmail) {
        this.inviteeEmail = inviteeEmail;
    }

    public User getInviter() {
        return inviter;
    }

    public void setInviter(User inviter) {
        this.inviter = inviter;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
