/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   12/09/2016.
 */

import javax.swing.JOptionPane; // needed for the input and message dialogues
import java.text.DecimalFormat; // needed for the DecimalFormat

public class Challenge2
{
    public static void main(String[] args)
    {
        DecimalFormat dollars = new DecimalFormat("#,##0.00");

        double wholesale;   // to hold the wholesale cost of the item
        double markup;      // to hold the markup percentage for the item
        double retailPrice; // to hold the returned retail price of the item

        // Get the user to input the wholesale price and markup percentage
        wholesale = getWholesale();
        markup = getMarkup();

        // Calculate the retail price
        retailPrice = calculateRetail(wholesale, markup);

        // Display the calculated retail price
        JOptionPane.showMessageDialog(null, "The retail price is $" +
                                            dollars.format(retailPrice));

        // Close the thread created by the message dialogue
        System.exit(0);
    }


    /**
     * The method getWholesale gets the user to input the wholesale price
     * @return The wholesale price as a double
     */
    public static double getWholesale()
    {
        String input;       // to hold the user's input
        double wholesale;   // to hold the wholesale cost of the item

        input = JOptionPane.showInputDialog("Enter the wholesale price:");
        wholesale = Double.parseDouble(input);

        return wholesale;
    }


    /**
     * The method getMarkup gets the user to input the markup percentage
     * @return The markup percentage as a double
     */
    public static double getMarkup()
    {
        String input;       // to hold the user's input
        double markup;      // to hold the markup percentage for the item

        input = JOptionPane.showInputDialog("Enter the markup percentage:");
        markup = Double.parseDouble(input);

        return markup;
    }


    /**
     *
     * @param wholesale The wholesale price of an item
     * @param markup The markup percentage of the item
     * @return The calculated retail price as a double
     */
    public static double calculateRetail(double wholesale, double markup)
    {
        return wholesale + (wholesale * (markup/100.0));
    }
}
