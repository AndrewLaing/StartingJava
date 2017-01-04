/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/12/2016.
 */

import java.text.DecimalFormat;

public class BankAccount
{
    private double balance;
    private int depositsMade;
    private int withdrawalsMade;
    private double annualInterestRate;
    private double monthlyServiceCharges;

    public BankAccount(double balance, double annualInterestRate)
    {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        depositsMade = 0;
        withdrawalsMade = 0;
    }

    public void deposit(double d)
    {
        balance += d;
        depositsMade++;
    }

    public void withdraw(double w)
    {
        balance -= w;
        withdrawalsMade++;
    }

    public void calcInterest()
    {
        double monthlyInterestRate = annualInterestRate/12.0;
        double monthlyInterest = balance * monthlyInterestRate;
        balance = balance + monthlyInterest;
    }

    public void monthlyProcess()
    {
        balance -= monthlyServiceCharges;
        calcInterest();
        depositsMade = 0;
        withdrawalsMade = 0;
        monthlyServiceCharges = 0;
    }


    public double getBalance() {
        return balance;
    }


    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setMonthlyServiceCharges(double monthlyServiceCharges) {
        this.monthlyServiceCharges = monthlyServiceCharges;
    }


    public int getWithdrawalsMade() {
        return withdrawalsMade;
    }


    public String toString() {
        DecimalFormat pounds = new DecimalFormat("£#0.00");
        return "\nBalance: " + pounds.format(balance) +
                "\nDeposits made in month: " + depositsMade +
                "\nWithdrawals made in month: " + withdrawalsMade +
                "\nAnnual Interest Rate: " + annualInterestRate;
    }
}
