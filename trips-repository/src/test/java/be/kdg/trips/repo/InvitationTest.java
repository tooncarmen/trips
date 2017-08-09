package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.InvitationsRepository;
import be.kdg.trips.core.entities.Invitation;
import be.kdg.trips.core.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvitationTest {
    InvitationsRepository invitationsRepository;

    @Before
    public void setUp() throws Exception {
        invitationsRepository = new InMemoryInvitationRepo();
    }

    @Test
    public void saveInvitation() throws Exception {
        Invitation invitation = new Invitation();
        User dirk = new User("Drik","dirk@mail.com","123");
        User jan = new User("Jan","jan@mail.com","321");
        invitation.setConfirmed(false);
        invitation.setInviter(dirk);
        invitation.setInvitee(jan);

        invitationsRepository.saveInvitation(invitation);
        Assert.assertTrue("invitations should be saved correctly",invitationsRepository.loadInvitationsByUser(jan).contains(invitation));
    }
}
