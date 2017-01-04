/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/08/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge9
{
    public static void main(String[] args) {
        double rate;        // To hold the rate
        double weight;         // To hold the weight of the package
        double distance;    // To hold the distance that the package that the package is being sent
        double toPay = 0;

        String input;       // To hold the user's input
        String result;      // To hold the result string

        // Create a formatter for the decimal output
        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Get the user to input the weight of the package
        input = JOptionPane.showInputDialog("Enter the weight of the package.");
        weight = Double.parseDouble(input);

        // Get the user to input the distance that they are sending the package.
        input = JOptionPane.showInputDialog("Enter the distance that you are sending the package.");
        distance = Double.parseDouble(input);

        // Calculate the rate per 500 Miles shipped
        if(weight<=2)
            rate = 1.10;
        else if(weight<=6)
            rate = 2.20;
        else if(weight<=10)
            rate = 3.70;
        else
            rate = 3.80;

        // Calculate the amount to pay
        while(distance>0) {
            toPay+=rate;
            distance-=500;
        }

        // Create the result string
        result = "The rate is $" + formatter.format(rate) + " per 500 miles shipped.\n";
        result += "Meaning you have to pay us $" + formatter.format(toPay) + ".";

        // Show the result to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the Message Dialogue
        System.exit(0);
    }
}
