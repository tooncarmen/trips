package be.kdg.tripsspringapp.dto;

import be.kdg.trips.core.entities.Invitation;
import be.kdg.trips.core.entities.Trip;
import be.kdg.trips.core.entities.User;

import java.time.LocalDateTime;

public class InvitationDTO {

    private boolean confirmed;
    private String inviteeEmail;
    private User inviter;
    private Trip trip;
    private LocalDateTime date;

    public Invitation toEntity() {
        return new Invitation(inviteeEmail,inviter, trip, date);
    }

}
