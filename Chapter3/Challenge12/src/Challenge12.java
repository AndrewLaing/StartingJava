/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   25/08/2016.
 */

import javax.swing.JOptionPane;
import  java.text.DecimalFormat;

public class Challenge12 {
    public static void main(String[] args) {
        String input;       // To hold the user's input
        String material;    // To hold the material that the sound will travel through
        String result;      // To hold the result string
        double distance;    // To hold the distance the sound must travel
        double time=0;      // To hold the time that it will take for the sound wave
                            // to travel through the material
        DecimalFormat formatter = new DecimalFormat("#0.00"); // To format the time taken for the result string

        // Get the user to enter the name of the material
        material = JOptionPane.showInputDialog("Enter the material that the sound wave will travel through.\nair, water or steel.").toLowerCase();

        // Get the user to enter the distance that the sound wave will travel
        input = JOptionPane.showInputDialog("Enter the distance in feet that the sound wave will travel");
        distance = Double.parseDouble(input);

        // Calculate the time taken
        if(material.equals("air"))
            time = distance / 1110;
        else if(material.equals("water"))
            time = distance / 4900;
        else if(material.equals("steel"))
            time = distance / 16400;
        else {
            JOptionPane.showMessageDialog(null, material + " is an invalid material!");
            System.exit(0);
        }

        // Create the result string
        result = "The sound wave will travel through the material in " + formatter.format(time);
        result += " seconds.";

        // Display the result
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the Message Dialogue
        System.exit(0);
    }
}
