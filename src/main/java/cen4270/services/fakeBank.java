package cen4270.services;

/**
 * Created by Caciano on 9/28/2016.
 */
public class fakeBank implements BankInterface
{
    public void chargeCreditCard(cardInterface card, int amount)
    {
        System.out.println("Charging a credit card. Amount: " + amount + "; Number: [Number omitted for security]...");

        System.out.println("...Credit card charged");
    }
}
