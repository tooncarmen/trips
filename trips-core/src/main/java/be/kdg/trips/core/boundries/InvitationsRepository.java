package be.kdg.trips.core.boundries;

import be.kdg.trips.core.entities.Invitation;
import be.kdg.trips.core.entities.User;

import java.util.List;

public interface InvitationsRepository {
    Invitation saveInvitation(Invitation invitation);
    List<Invitation> loadInvitationsByUser(User user);

}
