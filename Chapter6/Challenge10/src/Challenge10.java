/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/10/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge10
{
    public static void main(String[] args)
    {
        float air=0, sb=0;              // to hold the annual interest rate and the starting balance
        float deposited=0, withdrawn=0; // to hold the amounts deposited and withdrawn each month
        int months=0;                   // to hold the number of months that the account has been open for
        String input;                   // to hold the user's input

        // Create a DecimalFormat object for printing out the results
        DecimalFormat pounds = new DecimalFormat("#,##0.00");

        // Create a new SavingsAccount object
        SavingsAccount acct1 = new SavingsAccount();

        // --------------------------------------------------------------------
        //       Get the starting details from the user
        // --------------------------------------------------------------------

        // get the user to input the annual interest rate
        input = JOptionPane.showInputDialog("Please enter the annual interest rate.");

        // Make sure that user input is valid
        boolean inputNotValid = true;
        while (inputNotValid)
        {
            try
            {
                air = Float.parseFloat(input);
                if(air>0)
                    inputNotValid = false;
            }
            catch (NumberFormatException e)
            {
                input = JOptionPane.showInputDialog("Please enter a valid interest rate");
            }
        }

        // set the accounts annual interest rate
        acct1.setAnnualInterestRate(air);

        // get the user to input the starting balance
        input = JOptionPane.showInputDialog("Please enter the starting balance.");

        // Make sure that user input is valid
        inputNotValid = true;
        while (inputNotValid)
        {
            try
            {
                sb = Float.parseFloat(input);
                if(sb>0)
                    inputNotValid = false;
            }
            catch (NumberFormatException e)
            {
                input = JOptionPane.showInputDialog("Please enter a valid starting balance");
            }
        }

        // set the accounts starting balance and current balance
        acct1.setStartBalance(sb);
        acct1.setCurrentBalance(sb);


        // get the user to input the number of months the account has been open for
        input = JOptionPane.showInputDialog("How many months has the account been open for?");

        // Make sure that user input is valid
        inputNotValid = true;
        while (inputNotValid)
        {
            try
            {
                months = Integer.parseInt(input);
                if(months>0)
                    inputNotValid = false;
            }
            catch (NumberFormatException e)
            {
                input = JOptionPane.showInputDialog("Please enter a valid number of months");
            }
        }

        // --------------------------------------------------------------------
        //       Get the monthly details from the user
        // --------------------------------------------------------------------
        // Add the details for each month the account has been open for
        for(int i=0; i<months; i++)
        {
            // get the user to input the amount deposited during the month
            input = JOptionPane.showInputDialog("How much was deposited in month #" + (i+1));

            // Make sure that user input is valid
            inputNotValid = true;
            while (inputNotValid)
            {
                try
                {
                    deposited = Float.parseFloat(input);
                    if(deposited>=0)
                        inputNotValid = false;
                }
                catch (NumberFormatException e)
                {
                    input = JOptionPane.showInputDialog("Please enter amount for the money deposited.");
                }
            }

            // Add the deposited money to the total balance
            acct1.depositMoney(deposited);


            // get the user to input the amount withdrawn during the month
            input = JOptionPane.showInputDialog("How much was withdrawn in month #" + (i+1));

            // Make sure that user input is valid
            inputNotValid = true;
            while (inputNotValid)
            {
                try
                {
                    withdrawn = Float.parseFloat(input);
                    if(withdrawn>=0)
                        inputNotValid = false;
                }
                catch (NumberFormatException e)
                {
                    input = JOptionPane.showInputDialog("Please enter amount for the money deposited.");
                }
            }

            // Add the deposited money to the total balance
            acct1.withdrawMoney(withdrawn);

            // Calculate and add the interest for the month
            acct1.calculateMonthlyInterest();
        }

        // --------------------------------------------------------------------
        //       Display the results to the user
        // --------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "The current balance is $" + pounds.format(acct1.getCurrentBalance()) +
                                            "\nTotal deposits came to $" + pounds.format(acct1.getTotalDeposits()) +
                                            "\nTotal Withdrawals came to $" + pounds.format(acct1.getTotalWithdrawals()) +
                                            "\nTotal interest earned was $" + pounds.format(acct1.getTotalInterestEarned()));

        // Close the thread created by the message box
        System.exit(0);

    }
}
