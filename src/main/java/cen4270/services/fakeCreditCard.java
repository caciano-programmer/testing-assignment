package cen4270.services;

import java.util.Date;

/**
 * Created by Caciano on 9/26/2016.
 */
public class fakeCreditCard implements cardInterface
{
    private String number;
    private Date expirationDate;

    public fakeCreditCard(String number, Date expirationDate)
    {
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public String getNumber() { return number; }

    public Date getExpirationDate() {return expirationDate; }

    public void setNumber(String num) { number = num; }
}
