package be.kdg.trips.tripsInvitationmailer;


import be.kdg.trips.core.boundries.InvitationSender;
import be.kdg.trips.core.entities.Invitation;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class InvitationEmailer implements InvitationSender {

    //https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/

    //todo: naar resourses
    private Properties props = new Properties();
    private static final String USERNAME = "trip.inviter@gmail.com";
   private static  final String PASSWORD = "integratieproject";


    public InvitationEmailer() {
        setup();
    }

    @Override
    public void send(Invitation invitation) {

        Session session = createSession(USERNAME, PASSWORD);

        try {
            Message message = buildMessage(session, invitation);
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private Message buildMessage(Session session, Invitation invitation) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(USERNAME));

        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(invitation.getInviteeEmail()));

        message.setSubject("Trip met "+ invitation.getInviter().getUsername());
        message.setText(EmailFormatter.formatEmailBody(invitation));
        return message;
    }

    private Session createSession(String username, String password) {
        return Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
    }

    private void setup() {

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

}
