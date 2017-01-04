/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/09/2016.
 */

import javax.swing.JOptionPane;     // Used for the input/output dialogues

public class Challenge3
{
    public static void main(String[] args)
    {
        double length,      // The rectangle's length
                width,      // The rectangle's width
                area;       // The rectangle's area

        // Get the rectangle's length from the user.
        length = getLength();

        // Get the rectangle's width from the user.
        width = getWidth();

        // Get the rectangle's area.
        area = getArea(length, width);

        // Display the rectangle data.
        displayData(length, width, area);

        // Close the thread created by opening the message dialogue
        System.exit(0);
    }


    /**
     * The method getLength gets the user to enter the length
     * of the rectangle.
     * @return The inputted length as a double
     */
    public static double getLength()
    {
        double length;      // to hold the converted input
        String input;       // to hold the users input

        input = JOptionPane.showInputDialog("Enter the length of the rectangle");
        length = Double.parseDouble(input);

        return length;
    }


    /**
     * The method getWidth gets the user toi enter the width
     * of the rectangle
     * @return The inputted width as a double
     */
    public static double getWidth()
    {
        double width;       // to hold the converted input
        String input;       // to hold the users input

        input = JOptionPane.showInputDialog("Enter the width of the rectangle");
        width = Double.parseDouble(input);

        return width;
    }


    /**
     * The method get area calculates the area of the rectangle
     * @param length The length of the rectangle
     * @param width The width of the rectangle
     * @return The calculated area as a double
     */
    public static double getArea(double length, double width)
    {
        return length * width;
    }


    /**
     * The method display data shows the width, length and
     * calculated area of the rectangle to the user
     * @param area The area of the rectangle
     * @param width The width of the rectangle
     * @param length The length of the rectangle
     */
    public static void displayData(double area, double width, double length)
    {
        JOptionPane.showMessageDialog(null, "Width = " + width +
                                            "\nLength = " + length +
                                            "\nArea = " + area);
    }
}
