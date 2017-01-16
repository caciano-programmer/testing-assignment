package cen4270.services;
import cen4270.models.Region;

/**
 * Created by Caciano on 9/26/2016.
 */
public interface UserInterface
{
    public String getFirstName();
    public String getLastName();
    public String getEmail();
    public cardInterface getCreditCard();
    public Region getRegion();
    public boolean isPremiumUser();
}
