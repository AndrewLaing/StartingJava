/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/10/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge7
{
    public static void main(String[] args)
    {
        DecimalFormat result = new DecimalFormat("#0.00");
        String input;       // to hold the user's input
        double temp;        // to temporarily hold the user's input converted to a double

        // Create a Circle object
        Circle circ = new Circle();

        // get the circle's radius from the user
        input = JOptionPane.showInputDialog("Please enter the radius of the circle.");
        temp = Double.parseDouble(input);
        circ.setRadius(temp);

        // display the area, diameter and circumference of the circle to the user
        JOptionPane.showMessageDialog(null, "The circle's area is " + result.format(circ.getArea()) +
                                             "\nits diameter is " + result.format(circ.getDiameter()) +
                                             "\nand its circumference is " + result.format(circ.getCircumference()));

        // Close the thread created by the message dialogue
        System.exit(0);
    }

}
