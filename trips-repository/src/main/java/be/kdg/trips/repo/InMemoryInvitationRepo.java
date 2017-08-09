package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.InvitationsRepository;
import be.kdg.trips.core.entities.Invitation;
import be.kdg.trips.core.entities.User;
import be.kdg.trips.core.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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
    public List<Invitation> loadInvitationsByUser(User user) {
        List<Invitation> userInvitations = new ArrayList<>();
        invitations.stream().filter(i -> i.getInvitee().equals(user)).forEach(i -> userInvitations.add(i));
        if(userInvitations.isEmpty()) throw new NotFoundException("user '"+ user.getUsername()+ "' has no invitations");
        return userInvitations;
    }
}
