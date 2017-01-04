/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   08/11/2016.
 */

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Challenge1
{
    private final static int MONTHS = 12;
    private final static String[] monthNames = { "January", "February", "March", "April", "May", "June",
                                                 "July", "August", "September", "October", "November", "December"};

    public static void main(String[] args)
    {
        double months[] = new double[MONTHS];   // to hold the years rainfall totals

        getYearsData(months);
        displayResults(months);
        System.exit(0);
    }


    /**
     * The method getYearsData adds the monthly rainfall totals to the
     * array passed to it
     * @param months An array to contain the monthly rainfall totals
     */
    private static void getYearsData(double[] months)
    {
        String input;               // to hold the user's input
        double mthRainTotal;        // to hold each months rainfall total
        boolean validData = false;  // used as a flag for input validation

        // Get the values for each months rainfall
        for(int mth=0; mth<MONTHS; mth++)
        {
            validData = false;
            mthRainTotal = -1.0;
            input = JOptionPane.showInputDialog("Enter the total rainfall for " + monthNames[mth]);

            // While loop used to ensure that the user has entered valid data for the month
            while(!validData)
            {
                try{
                    mthRainTotal = Double.parseDouble(input);
                    // Rainfall total for the month cannot be negative
                    if(mthRainTotal>=0)
                        validData = true;
                    else
                        input = JOptionPane.showInputDialog("Please enter a valid positive value for " + monthNames[mth]);
                }
                catch (Exception e)
                {
                    input = JOptionPane.showInputDialog("Please enter a valid positive value for " + monthNames[mth]);
                }
            }

            // Add the month's rainfall to the array
            months[mth] = mthRainTotal;
        }
    }


    /**
     * The method display results displays the total and average rainfalls for
     * the year plus the months with the least and most rainfall.
     * @param months  An array containing the year's rainfall totals
     */
    private static void displayResults(double[] months)
    {
        DecimalFormat result = new DecimalFormat("#,##0.00");

        double average, total;    // to hold the average and total rainfalls for the year
        int min, max;             // to hold the subscripts of the months with the lowest and highest rainfalls

        total = getTotal(months);
        average = getAverageRainfall(total);
        min = getMin(months);
        max = getMax(months);

        JOptionPane.showMessageDialog(null, "Total rainfall: " + result.format(total) +
                "\nAverage rainfall: " + result.format(average) +
                "\nMonth with least rain: " + monthNames[min] +
                "\nMonth with most rain: " + monthNames[max+1]);
    }


    /**
     * The method getAverageRainfall returns the average rainfall for the year
     * @param total The total rainfall for the year
     * @return The average rainfall for the year
     */
    private static double getAverageRainfall(double total)
    {
            return total / MONTHS;
    }


    /**
     * The method getMin returns the subscript of the month with
     * the lowest rainfall
     * @param months An array containing the year's rainfall totals
     * @return The subscript of the month with the lowest rainfall
     */
    private static int getMin(double[] months)
    {
        double min = months[0];  // to hold the lowest rainfall value in the year
        int resultSubscript = 0; // to hold the subscript of the month with the lowest rainfall

        for(int i=0; i<months.length; i++)
        {
            if(months[i]<min) {
                min = months[i];
                resultSubscript = i;
            }
        }

        return resultSubscript;
    }


    /**
     * The method getMax returns the subscript of the month with
     * the most rainfall
     * @param months An array containing the year's rainfall totals
     * @return The subscript of the month with the most rainfall
     */
    private static int getMax(double[] months)
    {
        double max = months[0];  // to hold the largest rainfall value in the year
        int resultSubscript = 0; // to hold the subscript of the month with the most rainfall

        for(int i=0; i<months.length; i++)
        {
            if(months[i]>max) {
                max = months[i];
                resultSubscript = i;
            }
        }

        return resultSubscript;
    }


    /**
     * The method getTotal returns the total rainfall for the year
     * @param months An array containing the year's rainfall totals
     * @return The total rainfall for the year
     */
    public static double getTotal(double[] months)
    {
        double total = 0.0;

        for(double mth : months)
            total += mth;

        return total;
    }
}
