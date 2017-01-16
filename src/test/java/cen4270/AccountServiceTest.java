package cen4270;

import cen4270.services.*;
import cen4270.exceptions.RegisterUserException;
import org.junit.*;
import org.junit.Assert;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Caciano on 9/21/2016.
 */

public class AccountServiceTest
{
    fakeUser user, user2;
    fakeCreditCard card;
    AccountService account;
    GregorianCalendar calendar;
    Date date;

    @Before
    public void setUp() { account = new AccountService(); }

    @Test
    public void test_getRegisterUser_user_Exists()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004@fiu.edu", "Caciano", "Almeida", card);

        try { account.registerUser(user); }
        catch(RegisterUserException x) {}

        Assert.assertNotNull(account.getRegisteredUser("oalme004@fiu.edu"));
    }

    @Test
    public void test_getRegisterUser_user_DoesNotExists()
    {
        Assert.assertNull(account.getRegisteredUser("oalme004@fiu.edu"));
    }

    @Test
    public void creditCard_length_inValid_assertFalse()
    {
        calendar = new GregorianCalendar(2019, 8, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("123", date);
        Assert.assertFalse(account.calls_isCreditCardValid(card));
    }

    @Test
    public void creditCard_match_error_assertFalse()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("x23456789876543x", date);
        Assert.assertFalse(account.calls_isCreditCardValid(card));
    }

    @Test
    public void creditCard_expirationDate_expired_assertFalse()
    {
        calendar = new GregorianCalendar(2015, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        Assert.assertFalse(account.calls_isCreditCardValid(card));
    }

    @Test
    public void creditCard_is_valid_assertTrue()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        Assert.assertTrue(account.calls_isCreditCardValid(card));
    }

    @Test
    public void email_already_Exists()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004@fiu.edu", "Caciano", "Almeida", card);
        user2 = user;
        Exception expected = null;

        try
        {
            account.registerUser(user);
            account.registerUser(user2);
        }
        catch(RegisterUserException x) { expected = x; }

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "Email address already exists");
    }

    @Test
    public void first_and_last_Name_Missing_Error()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004@fiu.edu", "Caciano", null, card);
        user2 = new fakeUser("oalme004@fiu.edu", "", "Almeida", card);
        Exception expected = null;

        try
        {
            account.registerUser(user);
            account.registerUser(user2);
        }
        catch(RegisterUserException x) { expected = x; }

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "User must have a first and last name");
    }

    @Test
    public void email_matches_format_Error()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004fiu.edu", "Caciano", "Almeida", card);
        Exception expected = null;

        try { account.registerUser(user); }
        catch(RegisterUserException x) { expected = x; }

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "Email address is not valid");
    }

    @Test
    public void invalid_creditCard_in_RegisterUserMethod()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("foo", date);
        user = new fakeUser("oalme004@fiu.edu", "Caciano", "Almeida", card);
        Exception expected = null;

        try { account.registerUser(user); }
        catch(RegisterUserException x) { expected = x; }

        Assert.assertNotNull(expected);
        Assert.assertEquals(expected.getMessage(), "Credit card is not valid");
    }

    @Test
    public void registerUser_is_Success()
    {
        calendar = new GregorianCalendar(2019, 9, 1);
        date = calendar.getTime();
        card = new fakeCreditCard("1234567898765432", date);
        user = new fakeUser("oalme004@fiu.edu", "Caciano", "Almeida", card);
        Exception expected = null;

        try { account.registerUser(user); }
        catch(RegisterUserException x) { expected = x; }

        Assert.assertNull(expected);
    }
}
