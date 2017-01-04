/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/08/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge10 {
    public static void main(String[] args) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        String input;                   // To hold the user input
        String result = "";             // To hold the result string
        double calories, fatGrams;      // To hold the inputted number of calories and fatGrams
        double caloriesFromFat;         // To hold the calculated number of calories from fat
        double percentageOfCFF;         // To hold the percentage of calories from fat
        final int multiplier = 9;
		
        // Get the user to input the number of calories
        input = JOptionPane.showInputDialog("How many calories are in the food item");

        // Convert to a double and store it
        calories = Double.parseDouble(input);

        // Get the user to input the number of fat grams
        input = JOptionPane.showInputDialog("How manyy grams of fat are in the food item");

        // Convert to a double and store it
        fatGrams = Double.parseDouble(input);

        // Calculate the number of calories from fat
        caloriesFromFat = fatGrams * multiplier;

        // Test for erroneous input
        if(caloriesFromFat > calories) {
            JOptionPane.showMessageDialog(null, "Error - Invalid input!");
            System.exit(0);
        }

        // Calculate the percentage of calories from fat
        percentageOfCFF = caloriesFromFat / calories;

        // Create the result string
        result += "The percentage of calories from fat is " + formatter.format(percentageOfCFF) + "%";

        // Determine if the food is low in fat and if so add a message to the result string
        if(percentageOfCFF<30)
            result += "\nThis food item is low in fat!";

        // Show the message to the user
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the Message Dialog
        System.exit(0);
    }
}
