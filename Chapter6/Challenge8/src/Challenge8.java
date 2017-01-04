/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;


public class Challenge8
{
    public static void main(String[] args)
    {
        DecimalFormat pounds = new DecimalFormat("#,##0.00");
        String input;      // to hold the user's input

        // Create a new account
        BankCharges newAccount = new BankCharges(1014.0);

        // get the user to enter the number of checks cashed for the month
        input = JOptionPane.showInputDialog("How many checks were cashed this month?");
        newAccount.setChecksCashed( Math.abs(Integer.parseInt(input)) );

        // Display the charges for the month
        JOptionPane.showMessageDialog(null, "This months charges were $" + pounds.format(newAccount.calculateAndDeductServiceFees()));

        // Close the thread created by the message box
        System.exit(0);
    }
}
