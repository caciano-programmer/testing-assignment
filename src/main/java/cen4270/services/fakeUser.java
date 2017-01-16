package cen4270.services;
import cen4270.models.Region;

/**
 * Created by Caciano on 9/26/2016.
 */
public class fakeUser implements UserInterface
{
    private String email;
    private String FirstName;
    private String LastName;
    private cardInterface card;
    private boolean isPremiumUser;
    private Region region;

    //for accountService
    public fakeUser(String email, String FirstName, String LastName, cardInterface card)
    {
        this.email = email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.card = card;
    }
    //for purchaseService
    public fakeUser(String email, cardInterface card, boolean isPremiumUser, Region region, String FirstName, String LastName)
    {
        this.email = email;
        this.card = card;
        this.isPremiumUser = isPremiumUser;
        this.region = region;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String getFirstName() { return FirstName; }

    public String getLastName() { return LastName; }

    public String getEmail() { return email; }

    public cardInterface getCreditCard() { return card; }

    public boolean isPremiumUser() { return isPremiumUser; }

    public Region getRegion() { return region; }
}
