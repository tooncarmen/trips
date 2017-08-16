package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.InvitationsRepository;
import be.kdg.trips.core.entities.Invitation;
import be.kdg.trips.core.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryInvitationRepo implements InvitationsRepository{
    private List<Invitation> invitations;


    public InMemoryInvitationRepo() {
        invitations = new ArrayList<>();
    }

    @Override
    public Invitation saveInvitation(Invitation invitation) {
        invitations.add(invitation);
        return invitation;
    }

    @Override
    public List<Invitation> loadInvitationsByEmail(String email) {
        List<Invitation> userInvitations = new ArrayList<>();
        invitations.stream().filter(i -> i.getInviteeEmail().equals(email)).forEach(i -> userInvitations.add(i));
        if(userInvitations.isEmpty()) throw new NotFoundException("user '"+ email  + "' has no invitations");
        return userInvitations;
    }
}
