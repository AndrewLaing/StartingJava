/**
 * Author: Andrew Laing
 * Email:  parisianconnections@gmail.com
 * Date:   04/12/2016.
 */

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.text.DecimalFormat;


public class Challenge11
{
    private static final String fileName = "SalesData.txt";
    // ArrayLists cannot accept primitive types but can box and unbox the Double
    //   wrapper class
    private static ArrayList<Double> weeklyDailySalesAverages = new ArrayList<Double>();
    private static ArrayList<Double> weeklySalesTotals = new ArrayList<Double>();


    private static int getBestWeek()
    {
        int bestWeek = 0;
        double bestSales = weeklySalesTotals.get(0);

        for(int i=0; i<weeklySalesTotals.size(); i++) {
            if(weeklySalesTotals.get(i)>bestSales){
                bestSales = weeklySalesTotals.get(i);
                bestWeek = i;
            }
        }

        return bestWeek;
    }


    private static int getWorstWeek()
    {
        int worstWeek = 0;
        double worstSales = weeklySalesTotals.get(0);

        for(int i=0; i<weeklySalesTotals.size(); i++) {
            if(weeklySalesTotals.get(i)<worstSales){
                worstSales = weeklySalesTotals.get(i);
                worstWeek = i;
            }
        }

        return worstWeek;
    }



    private static double getTotalSales()
    {
        double total = 0;

        for(int i=0; i<weeklySalesTotals.size(); i++) {
            total += weeklySalesTotals.get(i);
        }

        return total;
    }


    private static double getAverageWeeklySales()
    {
        return getTotalSales() / weeklySalesTotals.size();
    }

    private static void printResults()
    {
        DecimalFormat fmt = new DecimalFormat("#0.00");

        String result = "\tRESULTS\n\n\tTotal Sales\tAverage Daily Sales\n";

        for(int i=0; i<weeklySalesTotals.size(); i++) {
            result += "Week " + (i+1) + "\t" +
                    fmt.format(weeklySalesTotals.get(i)) + "\t" +
                    fmt.format(weeklyDailySalesAverages.get(i)) +
                    "\n";
        }

        result += "\nTotal sales:\t\t" + fmt.format(getTotalSales());
        result += "\nAverage weekly sales:\t" + fmt.format(getAverageWeeklySales());
        result += "\nWeek with highest sales:\t" + "Week " + (getBestWeek() + 1);
        result += "\nWeek with lowest sales:\t" +  "Week " + (getWorstWeek() + 1);


        JOptionPane.showMessageDialog(null,new JTextArea(result));
    }


    private static void parseLine(String line)
    {
        double sum = 0;
        double dailyAverage = 0;
        String[] numbers = line.split(",");

        if(numbers.length==0)
            return;

        for(int i=0; i<numbers.length; i++)
        {
            sum += Double.parseDouble(numbers[i]);
        }

        dailyAverage = sum / numbers.length;
        weeklyDailySalesAverages.add(dailyAverage);
        weeklySalesTotals.add(sum);
        // Split the string here and add numbers to arrays
    }


    private static void readInLines() throws IOException
    {
        String line;

        FileReader freader = new FileReader(fileName);
        BufferedReader input = new BufferedReader(freader);

        line = input.readLine();

        while(line != null)
        {
            parseLine(line);
            line = input.readLine();
        }

        input.close();

        printResults();
    }


    public static void main(String[] args) throws IOException
    {
        readInLines();
        System.exit(0);

    }
}
