package cen4270;
import cen4270.exceptions.*;
import cen4270.services.*;
import org.junit.*;
import org.junit.Assert;
import cen4270.models.Item;
import cen4270.models.Region;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import cen4270.services.AccountService;

/**
 * Created by Caciano on 9/28/2016.
 */
public class PurchaseServiceTest
{
    private AccountService account;
    private PurchaseService purchase;
    private fakeBank bank;
    private fakeInventory inventory;
    private fakeNotification notification;
    private UserInterface user;
    private Calendar calendar;
    private Date date;
    private cardInterface card;
    private Item item;

    @Before
    public void setUp()
    {
        account = new AccountService();
        bank = new fakeBank();
        inventory = new fakeInventory();
        notification = new fakeNotification();
        purchase = new PurchaseService(account, bank, inventory, notification);
    }

    @Test
    public void  user_does_notExist()
    {
        Exception expected = null;
        try { purchase.purchaseItem("oalme004@fiu.edu", "random", 2); }
        catch(PurchaseException result) { expected = result; }
        catch(ChargeCreditCardException x) {}
        catch(SendEmailException y) {}

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "User does not exist");
    }

    @Test
    public void item_does_NotExist()
    {
        Exception expected = null;
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004@fiu.edu", "Caciano", "Almeida", card);
        try
        {
            account.registerUser(user);
            purchase.purchaseItem("oalme004@fiu.edu", "random", 2);
        }
        catch(PurchaseException result) { expected = result; }
        catch(ChargeCreditCardException x) {}
        catch(SendEmailException y) {}
        catch(RegisterUserException z) {}

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "Item does not exist");
    }

    @Test
    public void purchase_Success()
    {
        Exception A = null, B = null, C = null, D = null;
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004@fiu.edu", card, true, Region.East, "Caciano", "Almeida");

        try
        {
            account.registerUser(user);
            purchase.purchaseItem("oalme004@fiu.edu", "foo", 1);
        }
        catch(PurchaseException v) { A = v; }
        catch(ChargeCreditCardException x) { B = x; }
        catch(SendEmailException y) { C = y; }
        catch(RegisterUserException z) { D = z; }

        Assert.assertNull(A);
        Assert.assertNull(B);
        Assert.assertNull(C);
        Assert.assertNull(D);
    }

    @Test
    public void price_for_east_and_isPremium()
    {
        int price = 15, result = 0;
        Exception expected = null;
        user = new fakeUser("oalme004@fiu.edu", card, true, Region.East, "Caciano", "Almeida");
        Item item = new Item("foo", "bar", 10, 5);
        try { result = purchase.calculatePrice(user, item); }
        catch(PurchaseException x) { expected = x; }

        Assert.assertNull(expected);
        Assert.assertEquals(price, result);
    }

    @Test
    public void price_for_West_and_isPremium()
    {
        int price = 23, result = 0;
        Exception expected = null;
        user = new fakeUser("oalme004@fiu.edu", card, true, Region.West, "Caciano", "Almeida");
        Item item = new Item("foo", "bar", 10, 5);
        try { result = purchase.calculatePrice(user, item); }
        catch(PurchaseException x) { expected = x; }

        Assert.assertNull(expected);
        Assert.assertEquals(price, result);
    }

    @Test
    public void price_for_east_and_isNotPremium()
    {
        int price = 40, result = 0;
        Exception expected = null;
        user = new fakeUser("oalme004@fiu.edu", card, false, Region.Pacific, "Caciano", "Almeida");
        Item item = new Item("foo", "bar", 10, 5);
        try { result = purchase.calculatePrice(user, item); }
        catch(PurchaseException x) { expected = x; }

        Assert.assertNull(expected);
        Assert.assertEquals(price, result);
    }

    @Test
    public void price_for_default_Error_no_Region()
    {
        Exception expected = null;
        user = new fakeUser("oalme004@fiu.edu", card, true, Region.Other, "Caciano", "Almeida");
        Item item = new Item("foo", "bar", 10, 5);
        try { purchase.calculatePrice(user, item); }
        catch(PurchaseException x) { expected = x; }

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "Region is not supported");
    }
}
