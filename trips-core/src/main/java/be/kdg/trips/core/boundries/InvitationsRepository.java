package be.kdg.trips.core.boundries;

import be.kdg.trips.core.entities.Invitation;

import java.util.List;

public interface InvitationsRepository {
    Invitation saveInvitation(Invitation invitation);
    List<Invitation> loadInvitationsByEmail(String email);

}
