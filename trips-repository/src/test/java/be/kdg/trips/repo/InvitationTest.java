package be.kdg.trips.repo;

import be.kdg.trips.core.boundries.InvitationsRepository;
import be.kdg.trips.core.entities.Invitation;
import be.kdg.trips.core.entities.Label;
import be.kdg.trips.core.entities.Trip;
import be.kdg.trips.core.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

public class InvitationTest {
    InvitationsRepository invitationsRepository;

    @Before
    public void setUp() throws Exception {
        invitationsRepository = new InMemoryInvitationRepo();
    }

    @Test
    public void saveInvitation() throws Exception {
        User dirk = new User("Drik", "dirk@mail.com", "123");
        String jan = "jan@mail.com";
        List<Label> labels = Collections.singletonList(new Label("Adventure"));
        Trip t = new Trip("off to somewhere", "Just a hike", labels);
        Invitation invitation = new Invitation("jan", dirk, t, LocalDateTime.now());

        invitationsRepository.saveInvitation(invitation);
        Assert.assertTrue("invitations should be saved correctly", invitationsRepository.loadInvitationsByEmail(jan).contains(invitation));
    }
}
