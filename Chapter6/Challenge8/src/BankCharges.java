/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */
public class BankCharges
{
    private double balance;
    private int checksCashed;

    public BankCharges()
    {
        balance = 0.0;
        checksCashed = 0;
    }

    public BankCharges(double b)
    {
        balance = b;
        checksCashed = 0;
    }


    public void setBalance(double b)
    {
        balance = b;
    }

    public void setChecksCashed(int cc)
    {
        checksCashed = cc;
    }

    public double getBalance()
    {
        return balance;
    }

    public int getChecksCashed()
    {
        return checksCashed;
    }

    public double calculateAndDeductServiceFees()
    {
        double monthlyFees = 0.0;

        // Calculate the monthly charge
        if(balance < 400)
            monthlyFees += 15.0;
        else
            monthlyFees += 10.0;

        // Calculate the check fees
        if(checksCashed>=60)
            monthlyFees += (checksCashed * 0.04);
        else if(checksCashed>=40)
            monthlyFees += (checksCashed * 0.06);
        else if(checksCashed>=20)
            monthlyFees += (checksCashed * 0.08);
        else
            monthlyFees += (checksCashed * 0.1);

        // deduct the service fees from the balance
        setBalance(balance-monthlyFees);

        // return the total fees deducted for the month
        return monthlyFees;
    }




}
