/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   13/09/2016.
 */

import javax.swing.JOptionPane; // needed for the input/output dialogues
import java.text.DecimalFormat; // needed for the DecimalFormat class

public class Challenge4
{
    // GLOBAL CONSTANTS /////////////////////////////////////////
    // The square feet of wall space filled by per gallon of paint
    public static final int SPACE_FILLED_PER_GALLON = 115;
    // The hours of labour required to use one gallon of paint
    public static final int HOURS_PER_GALLON = 8;
    // The price of labour per hour
    public static final double LABOUR_COSTS_PER_HOUR = 18.0;


    // METHODS //////////////////////////////////////////////////

    public static void main(String[] args)
    {
        int rooms;
        double paintPrice, totalWallSpace=0;
        double paintRequired, hoursOfLabour, totalCostOfPaint, totalCostOfLabour;
        double totalCostToCustomer;

        rooms = getNumberOfRooms();
        paintPrice = getPaintPrice();

        // Get the wall space for each room
        for(int i=1; i<=rooms; i++)
            totalWallSpace += getWallSpace(i);

        paintRequired = calculatePaintRequired(totalWallSpace);
        hoursOfLabour = calculateHoursOfLabour(paintRequired);
        totalCostOfPaint = calculateCostOfPaint(paintRequired, paintPrice);
        totalCostOfLabour = calculateLabourCharges(hoursOfLabour);

        totalCostToCustomer = calculateTotalCost(totalCostOfPaint, totalCostOfLabour);

        displayResults(rooms, paintRequired, hoursOfLabour, totalCostOfPaint,
                       totalCostOfLabour, totalCostToCustomer);

        System.exit(0);
    }


    /**
     * The method getNumberOfRooms gets the user to input the
     * number of rooms in the building
     * @return The number of rooms as an int
     */
    public static int getNumberOfRooms()
    {
        String input;   // to hold the user's input
        int rooms;      // to hold the number of rooms

        input = JOptionPane.showInputDialog("Enter the number of rooms");
        rooms = Integer.parseInt(input);

        while(rooms<1)
        {
            input = JOptionPane.showInputDialog("Error - the number of rooms cannot be less than 1!\n" +
                                                "Enter the number of rooms");
            rooms = Integer.parseInt(input);
        }

        return rooms;
    }


    /**
     * The method getPaintPrice gets the user to input the
     * price of paint per gallon
     * @return The price of paint per gallon as a double
     */
    public static double getPaintPrice()
    {
        String input;       // to hold the user's input
        double paintPrice;  // to hold the price of paint per gallon

        input = JOptionPane.showInputDialog("Enter the price of the paint per gallon");
        paintPrice = Double.parseDouble(input);

        while(paintPrice < 0)
        {
            input = JOptionPane.showInputDialog("Error - the price of paint cannot be less than zero!\n" +
                    "Enter the price of the paint per gallon");
            paintPrice = Double.parseDouble(input);
        }

        return paintPrice;
    }


    /**
     * The method getWallSpace gets the user to input the
     * wall space in a specified room
     * @param roomNumber The number of the room
     * @return The wall space in the room as a double
     */
    public static double getWallSpace(int roomNumber)
    {
        String input;       // to hold the user's input
        double wallSpace;   // to hold the amount of wall space

        input = JOptionPane.showInputDialog("Enter the square feet of wall space in room " + roomNumber);
        wallSpace = Double.parseDouble(input);

        while (wallSpace<1)
        {
            input = JOptionPane.showInputDialog("Error - the wall space cannot be less than 1!\n" +
                    "Enter the square feet of wall space in room " + roomNumber);
            wallSpace = Double.parseDouble(input);
        }

        return wallSpace;
    }


    /**
     * The method calculatePaintRequired calculates the gallons
     * of paint that will be required to cover the given wall space
     * @param wallspace The amount of wall space to paint
     * @return The gallons of paint required as a double
     */
    public static double calculatePaintRequired(double wallspace)
    {
        // Calculate and return the number of gallons required
        return wallspace / SPACE_FILLED_PER_GALLON;
    }


    /**
     * The method calculateHours of labour calculates the hours of
     * labour that will be required to use the given gallons of paint
     * @param gallonsUsed The gallons of paint used on the job
     * @return The hours of labour required as a double
     */
    public static double calculateHoursOfLabour(double gallonsUsed)
    {
        // Calculate and return the hours of labour required
        return gallonsUsed * HOURS_PER_GALLON;
    }


    /**
     * The method calculate cost of paint calculates how much the given
     * amount of paint will cost, given the price of the paint
     * @param paintUsed The amount of paint used in gallons
     * @param paintPrice The price of the paint per gallon
     * @return
     */
    public static double calculateCostOfPaint(double paintUsed, double paintPrice)
    {
        // Calculate and return the price of the paint
        return paintUsed * paintPrice;
    }


    /**
     * The method calculateLabourCharges calculates the price of the
     * labour given the hours worked on the job
     * @param hoursOfLabour The number of hours worked on the job
     * @return The labour charges for the job as a double
     */
    public static double calculateLabourCharges(double hoursOfLabour)
    {
        // Calculate and return 6the labour costs
        return hoursOfLabour * LABOUR_COSTS_PER_HOUR;
    }


    /**
     * The method calculateTotalCost calculates the total cost of the
     * job to the customer
     * @param costOfPaint The total cost of the paint used on the job
     * @param labourCosts The total labour costs for the job
     * @return The total cost of the job as a double
     */
    public static double calculateTotalCost(double costOfPaint, double labourCosts)
    {
        // Calculate and return the total cost of the job to the customer
        return costOfPaint + labourCosts;
    }


    /**
     * The method displayResults displays the hours of labour required, the gallons
     * of paint required and the costs to the customer for the job.
     * @param rooms The number of rooms in the building
     * @param paintRequired The gallons of paint required for the job
     * @param hoursOfLabour The hours of labour required for the job
     * @param totalCostOfPaint The total costs of the paint used on the job
     * @param totalCostOfLabour The total costs for the labour used on the job
     * @param totalCost The total cost to the customer of the job
     */
    public static void displayResults(int rooms, double paintRequired, double hoursOfLabour,
                                      double totalCostOfPaint, double totalCostOfLabour,
                                      double totalCost)
    {
        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        DecimalFormat hours = new DecimalFormat("#0.0");

        JOptionPane.showMessageDialog(null, "To paint these " + rooms + " rooms\n" +
                                            "will require " + hours.format(hoursOfLabour) + " hours of labour\n" +
                                            "at a cost of $" + formatter.format(LABOUR_COSTS_PER_HOUR) + " per hour,\n" +
                                            "and " + formatter.format(paintRequired) + " gallons of paint.\n\n" +
                                            "The paint will cost a total of $" + formatter.format(totalCostOfPaint) +
                                            "\nand the labour a total of $" + formatter.format(totalCostOfLabour) +
                                            "\nmaking a total cost to you of $" + formatter.format(totalCost));
    }
}
