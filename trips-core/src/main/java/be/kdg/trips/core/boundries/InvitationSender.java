package be.kdg.trips.core.boundries;

import be.kdg.trips.core.entities.Invitation;

public interface InvitationSender {
    public void send(Invitation invitation);
}
