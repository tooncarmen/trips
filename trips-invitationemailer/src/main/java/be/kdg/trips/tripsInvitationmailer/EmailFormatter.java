package be.kdg.trips.tripsInvitationmailer;

import be.kdg.trips.core.entities.Invitation;

import java.time.format.DateTimeFormatter;

public class EmailFormatter {
    public static String formatEmailBody(Invitation invitation){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy om HH:mm");
        int atindex = invitation.getInviteeEmail().indexOf('@');

        return String.format("Best %s \n\n " +
                "Je werdt uitgenodigd door %s om een fantastische wandeltocht te maken op %s! \n" +
                "Surf naar %s en confirmeer je deelname!\n\n" +
                "Veel plezier tijdens je trip! \n" +
                "Trips. \n",
                invitation.getInviteeEmail().substring(0,atindex).replaceAll(".", " ").replaceAll("_", " "),
                 invitation.getDate().format(formatter),
                "http://whaterver-trips.com/trip/" + invitation.getTrip().getName()
                );
    }
}
