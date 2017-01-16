package cen4270.clients;

import cen4270.exceptions.SendEmailException;
import cen4270.models.Email;
import cen4270.services.NotificationInterface;

/**
 * This service is used to send emails
 */
public class NotificationClient implements NotificationInterface{
    /**
     * Sends an email
     * @param email The email to send
     * @throws SendEmailException Exception thrown if the email cannot be sent
     */
    public void sendEmail(Email email)  {
        System.out.println("Sending email...");

        System.out.println("To: " + email.getTo());
        System.out.println("Subject: " + email.getTitle());
        System.out.println("Message: " + email.getMessage());

        try {
            // The following sleep is used to simulate the time taken to
            // send an email over the web. A real implementation would
            // actually send out an email, but this should be enough for the
            // purpose of this assignment.
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("...Email sent.");
    }
}
