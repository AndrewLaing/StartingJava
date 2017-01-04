/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   15/11/2016.
 */

import javax.swing.JOptionPane;
import javax.swing.*;
import java.text.DecimalFormat;

public class Challenge6
{
    private static final int divisions = 6;
    private static final int quarters = 4;
    private static double[][]divisionSales = new double[divisions][quarters];
    private static DecimalFormat dollars = new DecimalFormat("#,##0.00");

    private static boolean isValidSalesFigure(double sales)
    {
        return sales >=0;
    }

    /**
     * The method getQuarterSales returns a valid sales figure for a specified division
     * for the specified quarter
     * @param division The index of a division
     * @param quarter The index of a quarter
     * @return A valid sales figure for a specified division for the specified quarter
     */
    private static double getQuartersSales(int division, int quarter)
    {
        double sales = 0;
        String input;
        boolean isValidInput = false;

        input = JOptionPane.showInputDialog("Enter the sales figures\nFor division #" + (division+1) +
                                             "\nFor quarter #" + (quarter+1) );

        while(!isValidInput)
        {
            try {
                sales = Double.parseDouble(input);
                if(isValidSalesFigure(sales))
                {
                    isValidInput = true;
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error - sales figure must be a positive number");
                input = JOptionPane.showInputDialog("Enter the sales figures\nFor division #" + (division+1) +
                        "\nFor quarter #" + (quarter+1) );
            }
        }

        return sales;
    }


    private static double getTotalSalesForQuarter(int quarter)
    {
        double totalSales = 0;

        for(int div=0; div<divisions; div++)
            totalSales += divisionSales[div][quarter];

        return totalSales;
    }

    private static double getAverageSalesForQuarter(int quarter)
    {
        double totalSales = 0;

        for(int div=0; div<divisions; div++)
            totalSales += divisionSales[div][quarter];

        return totalSales/divisions;
    }

    private static String getAverageSalesString(int quarter)
    {
        String avgSales = "Average division sales:\t";
        avgSales += dollars.format(getAverageSalesForQuarter(quarter));
        avgSales += "\n";

        return avgSales;
    }

    private static String getTotalSalesString(int quarter)
    {
        String totalSales = "\nTotal company sales:\t";
        totalSales += dollars.format(getTotalSalesForQuarter(quarter));
        totalSales += "\n";

        return totalSales;
    }

    private static String getCompanyIncrease(int quarter)
    {
        String increase = "Quarterly increase:\t";
        double increaseForQuarter = 0;

        if(quarter==0)
        {
            increase += "N/A\n";
            return increase;
        }

        increaseForQuarter = (getTotalSalesForQuarter(quarter) - getTotalSalesForQuarter(quarter-1));

        increase += dollars.format(increaseForQuarter);
        increase += "\n";

        return increase;
    }

    private static String getHeaders() {
        return "Division\tSales\tImprovement from previous quarter\t \n";
    }

    private static int getBestSellingDivision(int quarter)
    {
        double bestSales = 0;
        double sales;
        int bestDivision = 0;

        for(int div=0; div<divisions; div++)
        {
            sales = divisionSales[div][quarter];
            if(sales>bestSales){
                bestSales=sales;
                bestDivision = div;
            }
        }

        return bestDivision+1;
    }

    private static String getBestSellingDivisionString(int quarter)
    {
        return "Best selling division\t" + getBestSellingDivision(quarter);
    }


    /**
     * The method getDivisionQuarterlyStats constructs and returns a string
     * representing a specific divisions stats for the specified quarter
     * @param div The index of a division
     * @param qtr The index of a quarter
     * @return
     */
    private static String getDivisionQuarterlyStats(int div, int qtr)
    {
        String stats =  (div+1) + "\t";
        stats += dollars.format(divisionSales[div][qtr])
                + "\t";

        // Add the divisions increase or decrease since the previous quarter
        // excluding the first quarter
        if(qtr==0)
            stats += "N/A";
        else
            stats += dollars.format( (divisionSales[div][qtr] - divisionSales[div][qtr-1]));
        stats += "\n";
        return stats;
    }

    public static void displayQuartersResults(int qtr)
    {
        String result = "SALES STATISTICS FOR QUARTER #" + (qtr+1) + "\n\n";
        result += getHeaders();

        for(int div=0; div<divisions; div++)
            result += getDivisionQuarterlyStats(div, qtr);

        result += getTotalSalesString(qtr);
        result += getCompanyIncrease(qtr);
        result += getAverageSalesString(qtr);
        result += getBestSellingDivisionString(qtr);

        // Note using the testArea allows tabs and newlines to be displayed
        JOptionPane.showMessageDialog(null, new JTextArea(result));
    }



    public static void main(String[] args)
    {
        for(int div=0; div<divisions; div++ )
        {
            for(int qtr=0; qtr<quarters; qtr++)
            {
                divisionSales[div][qtr] = getQuartersSales(div, qtr);
            }
        }

        for(int qtr=0; qtr<quarters; qtr++)
            displayQuartersResults(qtr);

        System.exit(0);
    }
}
