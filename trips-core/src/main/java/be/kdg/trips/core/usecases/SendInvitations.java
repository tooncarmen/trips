package be.kdg.trips.core.usecases;

import be.kdg.trips.core.boundries.InvitationSender;
import be.kdg.trips.core.entities.Invitation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendInvitations {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendInvitations.class);
    private InvitationSender sender;

    public SendInvitations(InvitationSender sender) {
        this.sender = sender;
    }

    public void send(Invitation invitation){
        LOGGER.info("Invitation: sending to {}...",invitation.getInviteeEmail());
        sender.send(invitation);
    }
}
