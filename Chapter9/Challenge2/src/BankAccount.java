/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/11/2016.
 */

public class BankAccount
{
    private double balance;     // account balance


    /**
     * This constructor sets the starting balance at 0.0
     */
    public BankAccount()
    {
        balance = 0.0;
    }


    /**
     * Copy Constructor
     * @param object2 The object to be copied
     */
    public BankAccount(BankAccount object2)
    {
        balance = object2.balance;
    }


    /**
     * This constructor sets the starting balance to the
     * value passed as an argument.
     * @param startBalance The starting balance
     */
    public BankAccount(double startBalance)
    {
        balance = startBalance;
    }


    /**
     * This constructor sets the starting balance to the
     * value passed in the String argument.
     * @param str The starting balance as a String.
     */
    public BankAccount(String str)
    {
        balance = Double.parseDouble(str);
    }


    /**
     * The deposit method makes a deposit into the account
     * @param amount The amount to add to the balance field
     */
    public void deposit(double amount)
    {
        balance += amount;
    }


    /**
     * The deposit method makes a deposit into the account
     * @param str The amount to add to the balance field,
     *            as a String
     */
    public void deposit(String str)
    {
        balance += Double.parseDouble(str);
    }


    /**
     * The withdraw method withdraws an amount from the account
     * @param amount The amount to add to withdraw from the account
     */
    public void withdraw(double amount)
    {
        balance -= amount;
    }


    /**
     * The withdraw method withdraws an amount from the account
     * @param str The amount to add to withdraw from the account,
     *            as a String.
     */
    public void withdraw(String str)
    {
        balance -= Double.parseDouble(str);
    }


    /**
     * The setBalance method sets the account balance.
     * @param b The value to store in the balance field
     */
    public void setBalance(double b)
    {
        balance = b;
    }


    /**
     * The setBalance method sets the account balance.
     * @param str The value to store in the balance field,
     *            as a String.
     */
    public void setBalance(String str)
    {
        balance = Double.parseDouble(str);
    }


    public double getBalance()
    {
        return balance;
    }
}
