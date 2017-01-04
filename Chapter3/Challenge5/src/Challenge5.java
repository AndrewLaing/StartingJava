/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   23/08/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge5
{
    public static void main(String[] args) {
        String input, result, weightStr; // To hold the users input, the output string and the formatted weight
        double mass, weight;             // To hold the mass and the result of the calculation
        final double multiplier = 9.8;   // Used to calculate the weight
        DecimalFormat formatter = new DecimalFormat("#0.00");

        // Get the user to input the mass of the object
        input = JOptionPane.showInputDialog("Enter the mass of the object");
        // Convert to a double to store in mass
        mass = Double.valueOf(input);

        // Calculate the weight
        weight = mass * multiplier;

        // Create a formatted string from the weight
        weightStr = formatter.format(weight);

        // Create the result string
        if(mass<10)
            result = "The object is too light.";
        else if(mass>1000)
            result = "The object is too heavy.";
        else
            result = "The object weighs " + weightStr + " Newtons";

        // Show the result to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the MessageBox
        System.exit(0);
    }
}
