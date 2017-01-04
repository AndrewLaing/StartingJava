/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/12/2016.
 */
public class SavingsAccount extends BankAccount
{
    private boolean status;

    public SavingsAccount(BankAccount customerAccount)
    {
        super(customerAccount.getBalance(), customerAccount.getAnnualInterestRate());
        calcStatus();
    }

    public void withdraw(double w)
    {
        if(status) {
            super.withdraw(w);
            calcStatus();
        } else {
            System.out.println("Withdrawals not allowed the account is inactive!");
        }

    }

    public void deposit(double d)
    {
        super.deposit(d);
        calcStatus();
    }

    public void monthlyProcess()
    {
        double msc = getWithdrawalsMade() - 4;

        if(msc>0)
            setMonthlyServiceCharges(msc);

        super.monthlyProcess();

        calcStatus();
    }

    public void calcStatus()
    {
        if(getBalance() > 25.0)
            status = true;
        else
            status = false;
    }

    public String toString() {
        return "SAVINGS ACCOUNT"  +
                "\nAccount status: " + (status ? "Active\n" : "Inactive\n") +
                super.toString();
    }
}
