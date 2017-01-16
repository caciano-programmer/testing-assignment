package cen4270.services;
import cen4270.models.Email;
import cen4270.exceptions.SendEmailException;

/**
 * Created by Caciano on 9/28/2016.
 */
public class fakeNotification implements NotificationInterface
{
    /**
     * Sends an email
     * @param email The email to send
     * @throws SendEmailException Exception thrown if the email cannot be sent
     */
    public void sendEmail(Email email)
    {
        System.out.println("...Email sent.");
    }
}
