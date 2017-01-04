/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   10/11/2016.
 */

import javax.swing.*;

public class Challenge3
{

    private static final int[] ACCOUNTS = { 5658845, 4520125, 7895122, 8777541, 8451277, 1302850,
                                            8080152, 4562555, 5552012, 5050552, 7825877, 1250255,
                                            1005231, 6545231, 3852085, 7576651, 7881200, 4581002 };


    private static boolean sequentialSearch(int testNo)
    {
        for(int accNo : ACCOUNTS) {
            if (accNo == testNo)
                return true;
        }

        return false;
    }


    public static void main(String[] args)
    {
        String input;
        int testNo = 0;
        boolean isValidInput = false;
        boolean isValidAccount = false;

        // Get the user to input a valid integer for the account number
        input = JOptionPane.showInputDialog("Please enter the account number");
        while(!isValidInput){
            try {
                testNo = Integer.parseInt(input);
                isValidInput = true;
            }
            catch (Exception e){
                input = JOptionPane.showInputDialog("Please enter a valid account number");
            }
        }

        // Test the account number entered and show a suitable message
        isValidAccount = sequentialSearch(testNo);

        if(isValidAccount)
            JOptionPane.showMessageDialog(null, "You have entered a valid account number. Please proceed.");
        else
            JOptionPane.showMessageDialog(null, "You have entered an INVALID account number. Please contact your administrator.");

        System.exit(0);


    }
}
