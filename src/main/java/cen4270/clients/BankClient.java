package cen4270.clients;

import cen4270.exceptions.ChargeCreditCardException;
import cen4270.services.cardInterface;

/**
 * This service provides functionality to process transactions
 */
public class BankClient {
    /**
     * Charges a credit card
     * @param creditCard The credit card to charge
     * @param amount The amount to charge the credit card
     * @throws ChargeCreditCardException Exception thrown if the credit cannot be charged for any reason
     */
    public void chargeCreditCard(cardInterface creditCard, int amount) throws ChargeCreditCardException {
        System.out.println("Charging a credit card. Amount: " + amount + "; Number: [Number omitted for security]...");

        try {
            // The following sleep is used to simulate the bank service making
            // a request to charge the credit card's bank. A real implementation
            // would make the request over the internet and wait for the response.
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("...Credit card charged");
    }
}
