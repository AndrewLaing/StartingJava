/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/10/2016.
 */
public class SavingsAccount
{
    private float annualInterestRate =0;
    private float startBalance;
    private float currentBalance = 0;
    private float totalDeposits = 0;
    private float totalWithdrawals = 0;
    private float totalInterestEarned = 0;


    public SavingsAccount()
    {
        startBalance = 0.0F;
    }

    public SavingsAccount(float sb)
    {
        startBalance = sb;
    }

    public void setAnnualInterestRate(float air)
    {
        annualInterestRate = air;
    }

    public void setStartBalance(float sb)
    {
        startBalance = sb;
    }

    public void setCurrentBalance(float cb)
    {
        currentBalance = cb;
    }

    public float getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    public float getStartBalance()
    {
        return startBalance;
    }

    public float getCurrentBalance()
    {
        return currentBalance;
    }

    public float getTotalWithdrawals() {
        return totalWithdrawals;
    }

    public float getTotalDeposits() {
        return totalDeposits;
    }

    public float getTotalInterestEarned() {
        return totalInterestEarned;
    }

    public void depositMoney(float amount)
    {
        currentBalance += amount;
        totalDeposits += amount;
    }

    public void withdrawMoney(float amount)
    {
        currentBalance -= amount;
        totalWithdrawals += amount;
    }

    public void calculateMonthlyInterest()
    {
        float monthsInterest =  0;

        // Interest can only be added for accounts in credit
        if(currentBalance>0)
            monthsInterest = ((annualInterestRate/12.0f)/100) * currentBalance;

        // Add this months interest to the current balance
        currentBalance += monthsInterest;
        totalInterestEarned += monthsInterest;
    }

}
