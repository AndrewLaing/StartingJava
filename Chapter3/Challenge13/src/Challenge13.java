/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/08/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge13 {
    public static void main(String[] args) {
        String input;           // To hold the user's input
        String result;          // To hold the result string
        char packageLetter;     // To hold the letter of the users subscription package
        double totalCharges=0;  // To hold the total charges owed by the user
        int hours;              // To hold the hours used

        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Get the user to input the type of their subscription package
        input = JOptionPane.showInputDialog("What type of subscription package do you have?\n(A, B or C)").toUpperCase();

        // Check that the string is not empty
        if(input.length()<1) {
            JOptionPane.showMessageDialog(null, "Error - this field cannot be left empty!");
            System.exit(0);
        }

        packageLetter = input.charAt(0);

        // Get the number of hours used
        input = JOptionPane.showInputDialog("How many hours have you used?");
        hours = Integer.parseInt(input);

        // Calculate the total charges
        switch (packageLetter) {
            case 'A':
                totalCharges = 9.95;
                hours-=10;
                if(hours>0)
                    totalCharges += hours*2.0;
                break;
            case 'B':
                totalCharges = 13.95;
                hours-=20;
                if(hours>0)
                    totalCharges += hours*1.0;
                break;
            case 'C':
                totalCharges = 19.95;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error - Invalid Subscription Package type!");
                System.exit(0);
                break;
        }

        // Create the result string
        result = "The total charges will be $" + formatter.format(totalCharges);

        // Display the result to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the Message Dialogue
        System.exit(0);

    }
}
