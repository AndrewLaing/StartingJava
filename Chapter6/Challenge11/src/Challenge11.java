/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   06/10/2016.
 */

import java.io.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge11
{
    public static void main(String[] args) throws IOException
    {
        // Create a DecimalFormat object for printing out the results
        DecimalFormat pounds = new DecimalFormat("#,##0.00");

        FileReader freadDeposits        = new FileReader("Deposits.txt");
        BufferedReader inputDeposits    = new BufferedReader(freadDeposits);
        FileReader freadWithdrawals     = new FileReader("Withdrawals.txt");
        BufferedReader inputWithdrawals = new BufferedReader(freadWithdrawals);

        String str;     // for reading in the lines

        float totalDeposits=0, totalWithdrawals=0;  // to hold the totals read in from the files

        // Create a new SavingsAccount object with the starting balance of 500.00
        // and set the annual interest rate to 7.5%
        SavingsAccount acct1 = new SavingsAccount(500.00f);
        acct1.setAnnualInterestRate(7.5f);


        // --------------------------------------------------------------------
        //  Read in the monthly data from the files and update the account
        // --------------------------------------------------------------------

        // read in the lines from the Deposits file
        str = inputDeposits.readLine();
        while(str != null)
        {
            totalDeposits += Float.parseFloat(str);
            str = inputDeposits.readLine();
        }

        // close the deposits file
        inputDeposits.close();


        // read in the lines from the Withdrawals file
        str = inputWithdrawals.readLine();
        while(str != null)
        {
            totalWithdrawals += Float.parseFloat(str);
            str = inputWithdrawals.readLine();
        }

        // close the deposits file
        inputWithdrawals.close();

        // Update the account
        acct1.depositMoney(totalDeposits);
        acct1.withdrawMoney(totalWithdrawals);
        acct1.calculateMonthlyInterest();


        // --------------------------------------------------------------------
        //       Display the results to the user
        // --------------------------------------------------------------------

        JOptionPane.showMessageDialog(null, "The current balance is $" + pounds.format(acct1.getCurrentBalance()) +
                                          "\nTotal interest earned was $" + pounds.format(acct1.getTotalInterestEarned()));

        // Close the thread created by the message box
        System.exit(0);

    }
}
