/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   24/08/2016.
 */

import javax.swing.JOptionPane;     // For the Dialogue Boxes
import java.text.DecimalFormat;     // For the Decimal formatter

public class Challenge8 {
    public static void main(String[] args) {
        final double price = 99.0;

        String result;         // To hold the result string displayed to the user
        String input;               // To hold the user's input
        double total, discount;     // To hold the calculated result
        int packagesPurchased;      // To hold the number of packages purchased

        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Get the user to enter the number of packages that they require
        input = JOptionPane.showInputDialog("How many packages do you wish to purchase?");

        // Convert input string to an integer
        packagesPurchased = Integer.parseInt(input);

        // Calculate the price and the discount
        if(packagesPurchased < 10) {
            discount = 0;
            total = packagesPurchased * price;
        }
        else if(packagesPurchased < 20)
        {
            discount = packagesPurchased * 0.2;
            total = (packagesPurchased * price) - discount;
        }
        else if(packagesPurchased < 50) {
            discount = packagesPurchased * 0.3;
            total = (packagesPurchased * price) - discount;
        }
        else if(packagesPurchased < 100) {
            discount = packagesPurchased * 0.4;
            total = (packagesPurchased * price) - discount;
        }
        else {
            discount = packagesPurchased * 0.5;
            total = (packagesPurchased * price) - discount;
        }

        // Create the result string
        result = "You are allowed a discount of $" + formatter.format(discount);
        result += ".\nLeaving you a total of $" + formatter.format(total) + " to pay.";

        // Show the result to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the Message Dialogue
        System.exit(0);
    }
}
