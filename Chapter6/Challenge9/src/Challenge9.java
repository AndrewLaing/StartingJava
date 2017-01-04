/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   05/10/2016.
 */

import javax.swing.JOptionPane;

public class Challenge9
{
    public static void main(String[] args)
    {
        String input;
        float temp = 0;

        // Create a FreezingBoiling object
        FreezingBoiling userTemperature = new FreezingBoiling();

        // Get the user to input a temperature
        input = JOptionPane.showInputDialog("Enter a temperature");

        // Make sure that user input is valid
        boolean inputNotValid = true;
        while (inputNotValid) {
            try
            {
                temp = Float.parseFloat(input);
                inputNotValid = false;
            }
            catch (NumberFormatException e)
            {
                input = JOptionPane.showInputDialog("Please enter a valid temperature");
            }
        }

        // Set the temperature of the FreezingBoiling object
        userTemperature.setTemperature(temp);

        // Create the result string
        String result = "At " + input + " degrees Fahrenheit";

        if(userTemperature.isEthylFreezing())
            result += "\nEthyl will freeze";
        else if(userTemperature.isEthylBoiling())
            result += "\nEthyl will boil";

        if(userTemperature.isOxygenFreezing())
            result += "\nOxygen will freeze";
        else if(userTemperature.isOxygenBoiling())
            result += "\nOxygen will boil";

        if(userTemperature.isWaterFreezing())
            result += "\nWater will freeze";
        else if(userTemperature.isEthylBoiling())
            result += "\nWater will boil";

        // Display the result
        JOptionPane.showMessageDialog(null, result);

        // Close the thread created by the message dialogue
        System.exit(0);
    }
}
