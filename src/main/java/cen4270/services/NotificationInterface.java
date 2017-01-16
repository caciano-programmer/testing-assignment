package cen4270.services;
import cen4270.models.Email;

/**
 * Created by Caciano on 9/28/2016.
 */
public interface NotificationInterface
{
    public void sendEmail(Email email);
}
